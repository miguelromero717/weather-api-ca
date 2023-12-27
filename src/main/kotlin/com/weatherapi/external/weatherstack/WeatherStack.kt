package com.weatherapi.external.weatherstack

import com.weatherapi.external.weatherstack.dto.CurrentWeatherStackResponseDTO
import com.weatherapi.external.weatherstack.dto.ForecastWeatherStackResponseDTO
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface WeatherStack : AutoCloseable {

    @GET
    @Path("/current")
    fun getCurrentWeather(
        @QueryParam("access_key") accessKey: String,
        @QueryParam("query") query: String,
    ): CurrentWeatherStackResponseDTO

    @GET
    @Path("/forecast")
    fun getForecast(
        @QueryParam("access_key") accessKey: String,
        @QueryParam("query") query: String,
    ): ForecastWeatherStackResponseDTO
}
