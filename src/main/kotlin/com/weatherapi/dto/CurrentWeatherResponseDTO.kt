package com.weatherapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CurrentWeatherResponseDTO(
    override val location: LocationWeatherDTO,
    override val current: CurrentWeatherDTO,
) : IWeatherResponseDTO
