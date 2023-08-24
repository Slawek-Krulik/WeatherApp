package com.interview.weatherapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Icon(val text: String?, val url: String?): Parcelable
