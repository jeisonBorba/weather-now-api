package com.br.jeisonborba.weathernowapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public interface OpenWeatherService {

    HttpURLConnection connect(String urlString, Map<String, String> parameters) throws IOException;

    String extractJsonFromStream(InputStream inputStream) throws IOException;

    void disconnect(HttpURLConnection connection);
}
