package com.coolapps.jetweather.repository

import android.util.Log
import com.coolapps.jetweather.data.DataOrException
import com.coolapps.jetweather.model.Weather
import com.coolapps.jetweather.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String,units: String )
            : DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery,units = units)

        } catch (e: Exception) {
            Log.d("REX","getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE","getWeather: $response")
        return DataOrException(data = response)
    }

}
