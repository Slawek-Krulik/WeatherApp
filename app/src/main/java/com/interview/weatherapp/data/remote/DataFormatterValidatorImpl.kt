package com.interview.weatherapp.data.remote

import com.interview.weatherapp.core.DataFormatterValidator
import java.text.SimpleDateFormat
import java.util.Locale

class DataFormatterValidatorImpl: DataFormatterValidator {
    override fun isDateOnlyFormat(jsonDate: String?): Boolean = jsonDate?.let {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        dateFormat.isLenient = false

        try {
            dateFormat.parse(jsonDate)
            true
        } catch (e: Exception) {
            false
        }
    } ?: false
}