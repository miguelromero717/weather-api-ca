package com.weatherapi.repository

import com.weatherapi.dto.CurrentWeatherDTO
import com.weatherapi.dto.CurrentWeatherResponseDTO
import com.weatherapi.dto.DataForecastWeatherDTO
import com.weatherapi.dto.ForecastWeatherDTO
import com.weatherapi.dto.ForecastWeatherResponseDTO
import com.weatherapi.dto.LocationWeatherDTO
import com.weatherapi.external.weatherstack.WeatherStackService
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherRepository(
    private val weatherStackService: WeatherStackService,
) : IWeatherRepository {

    override fun getCurrentWeather(location: String?, lon: Double?, lat: Double?): CurrentWeatherResponseDTO {
        val query = weatherStackService.buildQuery(
            location = location,
            lon = lon,
            lat = lat,
        )
        val result = weatherStackService.getCurrentWeather(query)

        return CurrentWeatherResponseDTO(
            location = LocationWeatherDTO(
                name = result.location?.name,
                country = result.location?.country,
                region = result.location?.region,
                lat = result.location?.lat,
                lon = result.location?.lon,
            ),
            current = CurrentWeatherDTO(
                temperature = result.current?.temperature,
                weatherDescriptions = result.current?.weatherDescriptions,
                windDir = result.current?.windDir,
                pressure = result.current?.pressure,
                humidity = result.current?.humidity,
                precip = result.current?.precip,
            ),
        )
    }

    override fun getForecast(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): ForecastWeatherResponseDTO {
        val query = weatherStackService.buildQuery(
            location = location,
            lon = lon,
            lat = lat,
        )

        val result = weatherStackService.getForecast(
            query = query,
        )

        return ForecastWeatherResponseDTO(
            location = LocationWeatherDTO(
                name = result.location?.name,
                country = result.location?.country,
                region = result.location?.region,
                lat = result.location?.lat,
                lon = result.location?.lon,
            ),
            current = CurrentWeatherDTO(
                temperature = result.current?.temperature,
                weatherDescriptions = result.current?.weatherDescriptions,
                windDir = result.current?.windDir,
                pressure = result.current?.pressure,
                humidity = result.current?.humidity,
                precip = result.current?.precip,
            ),
            forecast = ForecastWeatherDTO(
                id = result.forecast?.id!!,
                data = DataForecastWeatherDTO(
                    date = result.forecast.data.date,
                    mintemp = result.forecast.data.mintemp,
                    maxtemp = result.forecast.data.maxtemp,
                    avgtemp = result.forecast.data.avgtemp,
                    sunhour = result.forecast.data.sunhour,
                ),
            ),
        )
    }
}
