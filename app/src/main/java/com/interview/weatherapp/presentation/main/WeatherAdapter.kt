package com.interview.weatherapp.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.interview.weatherapp.databinding.WeatherItemBinding
import com.interview.weatherapp.presentation.model.Weather
import androidx.databinding.library.baseAdapters.BR
import com.interview.weatherapp.R

class WeatherAdapter : ListAdapter<Weather, WeatherAdapter.WeatherViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
       return WeatherViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.weather_item, parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)
        val binding = holder.binding
        binding.setVariable(BR.item, item)

    }
    inner class WeatherViewHolder(val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Weather>() {
            override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
                return oldItem.city == newItem.city
                        && oldItem.icon == newItem.icon && oldItem.humidity == newItem.humidity
                        && oldItem.temperature == newItem.temperature
            }
        }
    }
}