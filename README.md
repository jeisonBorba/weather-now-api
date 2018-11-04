# Weather-now-api
Spring Boot API to fetch weather and forecast from OpenWeatherMap

## Requirements

For building and running the application you need:
All Maven plugins and dependencies are available from [Maven Central](https://search.maven.org/). Please have installed
* JDK 1.8
* Maven 3.3+
* Lombok 0.21+

### Building the application

```
mvn clean install
```

## Running the application locally

```shell
mvn spring-boot:run
```

## Exposed methods

This API has the following endpoints:

### `GET localhost:8080/api/city`

  This method is responsible for fetch all recorded cities in database.
  
### `POST localhost:8080/api/city/`

  This method is responsible for create a new city in database.

#### Arguments:
  * `city` [mandatory] string

### `DELETE localhost:8080/api/city/`

  This method is responsible for delete the city in database.

#### Arguments:
  * `id` [mandatory] long

### `GET localhost:8080/api/city/weather/`

  This method is responsible for fetch the real time cities weather from OpenWeatherMap API.
  
#### Arguments:
  * `citiesId [mandatory] list<>long`
  
### `GET localhost:8080/api/city/forecast/`

  This method is responsible for fetch 5 days forecast from OpenWeatherMap API.

#### Arguments:
  * `id [mandatory] long`
