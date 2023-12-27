package com.weatherapi.external.weatherstack

import com.weatherapi.external.IWeather
import com.weatherapi.external.weatherstack.dto.CurrentWeatherStackResponseDTO
import com.weatherapi.external.weatherstack.dto.ForecastWeatherStackResponseDTO
import jakarta.annotation.PreDestroy
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.RestClientBuilder
import java.net.URI

@ApplicationScoped
class WeatherStackService(
    @ConfigProperty(name = "weatherstack.api.key")
    private var apiKey: String,
) : IWeather {

    private lateinit var weatherStack: WeatherStack

    init {
        // Free plan doesn't allow https
        val uri = "http://api.weatherstack.com"
        weatherStack = RestClientBuilder.newBuilder()
            .baseUri(URI(uri))
            .build(WeatherStack::class.java)
    }

    @PreDestroy
    fun destroy() {
        weatherStack.close()
    }

    fun getCurrentWeather(
        query: String,
    ): CurrentWeatherStackResponseDTO {
        return weatherStack.getCurrentWeather(
            accessKey = apiKey,
            query = query,
        )
    }

    fun getForecast(
        query: String,
        forecastDays: Int? = null,
        hourly: Int? = null,
        interval: Int? = null,
    ): ForecastWeatherStackResponseDTO {
        return weatherStack.getForecast(
            accessKey = apiKey,
            query = query,
        )
    }
}
