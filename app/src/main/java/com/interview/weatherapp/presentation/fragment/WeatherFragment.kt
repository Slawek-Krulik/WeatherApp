package com.interview.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.interview.weatherapp.R
import com.interview.weatherapp.core.BindingFragment
import com.interview.weatherapp.databinding.WeatherFragmentBinding
import com.interview.weatherapp.presentation.model.Weather
import org.koin.androidx.viewmodel.ext.android.viewModel

const val WEATHER_EXTRA = "weather_extra"
class WeatherFragment : BindingFragment<WeatherFragmentBinding>(R.layout.weather_fragment) {

    private val viewModel: WeatherViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = super.onCreateView(inflater, container, savedInstanceState)
        .also { binding?.viewModel = viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setData(arguments?.getParcelable(WEATHER_EXTRA) as? Weather)
    }
}