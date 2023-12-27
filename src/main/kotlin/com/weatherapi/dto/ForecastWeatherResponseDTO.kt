package com.weatherapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ForecastWeatherResponseDTO(
    override val location: LocationWeatherDTO,
    override val current: CurrentWeatherDTO,
    val forecast: ForecastWeatherDTO,
) : IWeatherResponseDTO

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ForecastWeatherDTO(
    val id: String,
    val data: DataForecastWeatherDTO,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class DataForecastWeatherDTO(
    val date: String?,
    val mintemp: Int?,
    val maxtemp: Int?,
    val avgtemp: Int?,
    val sunhour: Double?,
)
