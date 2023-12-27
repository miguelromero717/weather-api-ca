package com.weatherapi.repository

import com.weatherapi.dto.CurrentWeatherResponseDTO
import com.weatherapi.dto.ForecastWeatherResponseDTO

interface IWeatherRepository {

    fun getCurrentWeather(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): CurrentWeatherResponseDTO

    fun getForecast(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): ForecastWeatherResponseDTO
}
