package com.weatherapi

import com.weatherapi.dto.CurrentWeatherResponseDTO
import com.weatherapi.dto.ForecastWeatherResponseDTO
import jakarta.enterprise.context.RequestScoped
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@RequestScoped
@Path("/weather")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class WeatherResource(
    private val weatherService: IWeatherService,
) {

    @GET
    @Path("/current")
    fun getCurrentWeather(
        @QueryParam("location") location: String?,
        @QueryParam("lon") lon: Double?,
        @QueryParam("lat") lat: Double?,
    ): CurrentWeatherResponseDTO? {
        return weatherService.getCurrentWeather(
            location = location,
            lon = lon,
            lat = lat,
        )
    }

    @GET
    @Path("/forecast")
    fun getForecast(
        @QueryParam("location") location: String?,
        @QueryParam("lon") lon: Double?,
        @QueryParam("lat") lat: Double?,

        @DefaultValue("7")
        @Max(14)
        @Min(1)
        @QueryParam("forecastDays")
        forecastDays: Int?,

        @DefaultValue("false")
        @QueryParam("hourly")
        hourly: Boolean?,

        @DefaultValue("1")
        @QueryParam("interval")
        interval: Int?,
    ): ForecastWeatherResponseDTO? {
        return weatherService.getForecast(
            location = location,
            lon = lon,
            lat = lat,
        )
    }
}
