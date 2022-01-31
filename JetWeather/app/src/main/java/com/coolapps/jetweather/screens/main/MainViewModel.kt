package com.coolapps.jetweather.screens.main

import androidx.lifecycle.ViewModel
import com.coolapps.jetweather.data.DataOrException
import com.coolapps.jetweather.model.Weather
import com.coolapps.jetweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel(){

    suspend fun getWeatherData(city: String, units: String)
            : DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city, units = units
        )
    }
}