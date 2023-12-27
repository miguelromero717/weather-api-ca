package com.weatherapi

import com.weatherapi.dto.CurrentWeatherResponseDTO
import com.weatherapi.dto.ForecastWeatherResponseDTO
import com.weatherapi.repository.IWeatherRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherService(
    private val weatherRepository: IWeatherRepository,
) : IWeatherService {

    override fun getCurrentWeather(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): CurrentWeatherResponseDTO {
        return weatherRepository.getCurrentWeather(
            location = location,
            lon = lon,
            lat = lat,
        )
    }

    override fun getForecast(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): ForecastWeatherResponseDTO {
        return weatherRepository.getForecast(
            location = location,
            lon = lon,
            lat = lat,
        )
    }
}
