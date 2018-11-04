package com.br.jeisonborba.weathernowapi.service;

import com.br.jeisonborba.weathernowapi.model.City;
import com.br.jeisonborba.weathernowapi.model.currentWeather.CurrentWeather;
import com.br.jeisonborba.weathernowapi.model.forecast.CurrentForecast;

import java.util.List;

public interface WeatherService {

    CurrentWeather queryWeatherByCities(List<Long> citiesId) throws Exception;

    CurrentForecast queryForecastByCity(Long cityId) throws Exception;

    City queryCity(String name);
}
