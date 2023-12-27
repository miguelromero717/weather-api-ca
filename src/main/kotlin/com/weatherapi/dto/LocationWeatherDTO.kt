package com.weatherapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class LocationWeatherDTO(
    val name: String?,
    val country: String?,
    val region: String?,
    val lat: String?,
    val lon: String?,
)
