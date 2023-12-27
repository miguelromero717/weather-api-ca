package com.weatherapi.external.weatherstack.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

interface WeatherStackResponseDTO {
    var request: Request?
    var location: Location?
    var current: Current?
}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Request(
    val type: String?,
    val query: String?,
    val language: String?,
    val unit: String?,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Location(
    val name: String?,
    val country: String?,
    val region: String?,
    val lat: String?,
    val lon: String?,
    val timezoneId: String?,
    val localtime: String?,
    val localtimeEpoch: Long?,
    val utcOffset: String?,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Current(
    val observationTime: String?,
    val temperature: Int?,
    val weatherCode: Int?,
    val weatherIcons: List<String>?,
    val weatherDescriptions: List<String>?,
    val windSpeed: Int?,
    val windDegree: Int?,
    val windDir: String?,
    val pressure: Int?,
    val precip: Int?,
    val humidity: Int?,
    val cloudcover: Int?,
    val feelslike: Int?,
    val uvIndex: Int?,
    val visibility: Int?,
)
