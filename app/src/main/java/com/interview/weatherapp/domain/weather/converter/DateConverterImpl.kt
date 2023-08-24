package com.interview.weatherapp.domain.weather.converter

import com.interview.weatherapp.domain.weather.DateConverter
import java.text.SimpleDateFormat
import java.util.Locale

private const val DATE_INPUT_PATTERN = "yyyy-MM-dd"
private const val DATE_OUTPUT_PATTERN = "dd MMMM yyyy"
class DateConverterImpl: DateConverter {
    override fun convert(input: String?): String =
        input?.let {
            val inputFormat = SimpleDateFormat(DATE_INPUT_PATTERN, Locale.ENGLISH)
            val outputFormat = SimpleDateFormat(DATE_OUTPUT_PATTERN, Locale("pl"))

            inputFormat.parse(input)?.let {
                outputFormat.format(it)
            }
        } ?: ""
}