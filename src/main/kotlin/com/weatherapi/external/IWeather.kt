package com.weatherapi.external

interface IWeather {

    fun buildQuery(
        location: String?,
        lon: Double?,
        lat: Double?,
    ): String {
        if (location?.isNotBlank() == true) {
            return location
        }

        if (lon != null && lat != null) {
            return "$lat,$lon"
        }

        throw IllegalArgumentException("location or lon and lat must be provided")
    }
}
