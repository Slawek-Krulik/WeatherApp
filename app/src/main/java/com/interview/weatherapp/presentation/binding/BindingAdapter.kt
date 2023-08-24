package com.interview.weatherapp.presentation.binding

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.interview.weatherapp.core.UiState

@BindingAdapter("uistate")
fun ProgressBar.setVisibility(uiState: UiState?) {
    visibility = if (uiState == UiState.Pending) View.VISIBLE else View.GONE
}

@BindingAdapter("onBottomNavListener")
fun BottomNavigationView.setListener(listener: NavigationBarView.OnItemSelectedListener) {
    setOnItemSelectedListener(listener)
}