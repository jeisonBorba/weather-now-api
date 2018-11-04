package com.br.jeisonborba.weathernowapi.service.impl;

import com.br.jeisonborba.weathernowapi.controller.CityNotFoundException;
import com.br.jeisonborba.weathernowapi.model.City;
import com.br.jeisonborba.weathernowapi.model.currentWeather.CurrentWeather;
import com.br.jeisonborba.weathernowapi.model.forecast.CurrentForecast;
import com.br.jeisonborba.weathernowapi.service.WeatherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class WeatherServiceImpl extends OpenWeatherServiceImpl implements WeatherService {

    private static final String URL_BASE        = "http://api.openweathermap.org/data/2.5/";
    private static final String URI_WEATHER     = "weather?";
    private static final String URI_GROUP       = "group?";
    private static final String URI_FORECAST    = "forecast?";

    @Override
    public CurrentWeather queryWeatherByCities(List<Long> citiesId) throws Exception {
        StringJoiner sj = new StringJoiner(",");
        for (long id : citiesId) {
            sj.add(String.valueOf(id));
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("id", sj.toString());
        return (CurrentWeather) query(URL_BASE.concat(URI_GROUP), params, CurrentWeather.class);
    }

    @Override
    public CurrentForecast queryForecastByCity(Long cityId) throws Exception {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(cityId));
        params.put("cnt", "5");
        return (CurrentForecast) query(URL_BASE.concat(URI_FORECAST), params, CurrentForecast.class);
    }

    @Override
    public City queryCity(String cityName) {
        HashMap<String, String> params = new HashMap<>();
        params.put("q", cityName);
        try {
            return (City) query(URL_BASE.concat(URI_WEATHER), params, City.class);
        } catch (Exception e) {
            throw  new CityNotFoundException("City not found " + cityName);
        }
    }

    private Object query(String url, Map<String, String> params, Class classs) throws Exception {
        HttpURLConnection connection = null;

        String json;
        Gson gson;
        try {
            connection = connect(url, params);
            if (connection == null) {
                throw new Exception("App couldn't connect to OpenWeather");
            }
            json = extractJsonFromStream(connection.getInputStream());
            gson = new GsonBuilder().setPrettyPrinting().create();

        } finally {
            disconnect(connection);
        }
        return gson.fromJson(json, classs);
    }
}
