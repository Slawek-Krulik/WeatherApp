package com.interview.weatherapp.core

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}