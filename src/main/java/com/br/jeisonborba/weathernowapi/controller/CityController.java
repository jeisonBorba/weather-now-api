package com.br.jeisonborba.weathernowapi.controller;

import com.br.jeisonborba.weathernowapi.model.City;
import com.br.jeisonborba.weathernowapi.model.currentWeather.CurrentWeather;
import com.br.jeisonborba.weathernowapi.model.db.CityDB;
import com.br.jeisonborba.weathernowapi.model.forecast.CurrentForecast;
import com.br.jeisonborba.weathernowapi.service.CityService;
import com.br.jeisonborba.weathernowapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/city")
public class CityController {

    private CityService cityService;
    private WeatherService weatherService;

    @Autowired
    public CityController(CityService cityService, WeatherService weatherService) {
        this.cityService = cityService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity listAllCities() {
        List<CityDB> cities = cityService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping(path = "/weather/{citiesId}")
    public ResponseEntity findWeather(@PathVariable(value = "citiesId") List<Long> citiesId) throws Exception {
        CurrentWeather currentWeather = weatherService.queryWeatherByCities(citiesId);
        return ResponseEntity.status(HttpStatus.OK).body(currentWeather);
    }

    @GetMapping(path = "/forecast/{id}")
    public ResponseEntity findForecast(@PathVariable(value = "id") Long id) throws Exception {
        CurrentForecast currentForecast = weatherService.queryForecastByCity(id);
        return ResponseEntity.status(HttpStatus.OK).body(currentForecast);
    }

    @PostMapping(path = "/{city}")
    public ResponseEntity create(@PathVariable(value = "city") String cityName) throws Exception {
        if (cityService.findOne(cityName) != 0L) {
            throw new Exception("City already used: "+ cityName);
        }
        City city = weatherService.queryCity(cityName);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.create(city));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        cityService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

}
