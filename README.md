# weather-api-ca

API to fetch weather data from [WeatherStack](https://weatherstack.com/)

## Getting started

### Prerequisites

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Gradle](https://gradle.org/releases/)
- [Kotlin](https://kotlinlang.org/docs/getting-started.html)
- [Quarkus](https://quarkus.io/get-started/)

### Running the application locally

```bash
./gradlew quarkusDev
```

## URL Access

The API Documentation is available at http://159.69.116.26:8181/q/swagger-ui/

## Endpoints

### Current

* `GET` http://159.69.116.26:8181/current
  * Query Params
    * **location** = Berlin
    * **lon** = 10.10
    * **lat** = 11.11

### Forecast

* `GET` http://159.69.116.26:8181/forecast
    * Query Params
        * **location** = Berlin
        * **lon** = 10.10
        * **lat** = 11.11