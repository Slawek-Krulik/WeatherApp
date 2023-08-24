package com.interview.weatherapp.presentation

import androidx.lifecycle.LiveData
import com.google.android.material.navigation.NavigationBarView
import com.interview.weatherapp.core.UiState

interface MainActivityView {

    val uiState: LiveData<UiState?>

    val onBottomNavClickListener: NavigationBarView.OnItemSelectedListener
}