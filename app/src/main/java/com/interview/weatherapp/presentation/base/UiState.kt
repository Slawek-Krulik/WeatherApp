package com.interview.weatherapp.presentation.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}