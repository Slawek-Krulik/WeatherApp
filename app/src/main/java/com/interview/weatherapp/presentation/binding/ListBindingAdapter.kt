package com.interview.weatherapp.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.interview.weatherapp.presentation.fragment.WeatherAdapter
import com.interview.weatherapp.presentation.model.Weather

@BindingAdapter("items")
fun RecyclerView.setItems(items: List<Weather?>?) {
    items?.also {
        adapter = WeatherAdapter().apply {
            submitList(it)
        }
    }


}