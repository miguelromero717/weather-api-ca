package com.weatherapi.external.weatherstack.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CurrentWeatherStackResponseDTO(
    override var request: Request?,
    override var location: Location?,
    override var current: Current?,
) : WeatherStackResponseDTO
