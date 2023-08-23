package com.interview.weatherapp.core

interface DataFormatterValidator {
    fun isDateOnlyFormat(jsonDate: String?): Boolean
}