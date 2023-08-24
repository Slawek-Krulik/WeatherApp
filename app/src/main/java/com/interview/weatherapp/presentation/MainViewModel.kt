package com.interview.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.navigation.NavigationBarView
import com.hadilq.liveevent.LiveEvent
import com.interview.weatherapp.R
import com.interview.weatherapp.core.BaseViewModel
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.domain.location.LocationTracker
import com.interview.weatherapp.domain.weather.GetWeatherUseCase
import com.interview.weatherapp.domain.weather.model.Weather
import kotlinx.coroutines.launch

class MainViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val locationTracker: LocationTracker,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper), MainActivityView {

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    override val uiState: LiveData<UiState?> = _uiState

    override val onBottomNavClickListener: NavigationBarView.OnItemSelectedListener =
        NavigationBarView.OnItemSelectedListener {item ->
            when(item.itemId) {
                R.id.first_day -> startWeatherFragment(0)
                R.id.second_day -> startWeatherFragment(1)
                else -> startWeatherFragment(2)
            }
            true
        }

    private val _weather = MutableLiveData<List<Weather?>?>()

    val startFragmentEvent: LiveEvent<Weather?> = LiveEvent()
    init {
        fetchData()
    }

    private fun fetchData() {
        _uiState.value = UiState.Pending
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.also { location ->
                getWeatherUseCase(
                    params = 3 to location,
                    scope = viewModelScope
                ) { result ->
                    result.onSuccess {
                        _weather.value = it
                        startWeatherFragment(0)
                    }
                    result.onFailure { handleFailure(it) }
                    _uiState.value = UiState.Idle
                }
            }
        }
    }

    private fun startWeatherFragment(index: Int) {
        _weather.value?.takeIf { it.isNotEmpty() && it.size > index}?.also {
            startFragmentEvent.value = it[index]
        }
    }

}