package com.weatherapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CurrentWeatherDTO(
    val temperature: Int?,
    val weatherDescriptions: List<String>?,
    val windDir: String?,
    val pressure: Int?,
    val precip: Int?,
    val humidity: Int?,
)
