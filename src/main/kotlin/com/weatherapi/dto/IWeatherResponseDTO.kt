package com.weatherapi.dto

sealed interface IWeatherResponseDTO {
    val location: LocationWeatherDTO
    val current: CurrentWeatherDTO
}
