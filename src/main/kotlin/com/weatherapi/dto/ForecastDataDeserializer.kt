package com.weatherapi.dto

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.weatherapi.external.weatherstack.dto.Astro
import com.weatherapi.external.weatherstack.dto.Forecast
import com.weatherapi.external.weatherstack.dto.ForecastDay
import java.util.UUID

class ForecastDataDeserializer : JsonDeserializer<Forecast>() {

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Forecast? {
        val node = p?.codec?.readTree<JsonNode>(p)
        val id = node?.fieldNames()?.next() ?: UUID.randomUUID().toString()

        return Forecast(
            id = id,
            data = ForecastDay(
                date = node?.first()?.get("date")?.asText(),
                dateEpoch = node?.first()?.get("date_epoch")?.asLong(),
                astro = Astro(
                    sunrise = node?.first()?.get("astro")?.get("sunrise")?.asText(),
                    sunset = node?.first()?.get("astro")?.get("sunset")?.asText(),
                    moonrise = node?.first()?.get("astro")?.get("moonrise")?.asText(),
                    moonset = node?.first()?.get("astro")?.get("moonset")?.asText(),
                    moonPhase = node?.first()?.get("astro")?.get("moon_phase")?.asText(),
                    moonIllumination = node?.first()?.get("astro")?.get("moon_illumination")?.asInt(),
                ),
                mintemp = node?.first()?.get("mintemp")?.asInt(),
                maxtemp = node?.first()?.get("maxtemp")?.asInt(),
                avgtemp = node?.first()?.get("avgtemp")?.asInt(),
                totalsnow = node?.first()?.get("totalsnow")?.asInt(),
                sunhour = node?.first()?.get("sunhour")?.asDouble(),
                uvIndex = node?.first()?.get("uv_index")?.asInt(),
            ),
        )
    }
}
