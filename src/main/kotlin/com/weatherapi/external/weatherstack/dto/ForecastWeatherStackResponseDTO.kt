package com.weatherapi.external.weatherstack.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.weatherapi.dto.ForecastDataDeserializer

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ForecastWeatherStackResponseDTO(
    override var request: Request?,
    override var location: Location?,
    override var current: Current?,
    val forecast: Forecast?,
) : WeatherStackResponseDTO

@JsonDeserialize(using = ForecastDataDeserializer::class)
data class Forecast(
    val id: String,
    val data: ForecastDay,
)

data class ForecastDay(
    val date: String?,
    val dateEpoch: Long?,
    val astro: Astro?,
    val mintemp: Int?,
    val maxtemp: Int?,
    val avgtemp: Int?,
    val totalsnow: Int?,
    val sunhour: Double?,
    val uvIndex: Int?,
)

data class Astro(
    val sunrise: String?,
    val sunset: String?,
    val moonrise: String?,
    val moonset: String?,
    val moonPhase: String?,
    val moonIllumination: Int?,
)
