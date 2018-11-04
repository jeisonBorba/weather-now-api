package com.br.jeisonborba.weathernowapi.service.impl;

import com.br.jeisonborba.weathernowapi.service.OpenWeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

    private static final String APP_ID  = "ae25426535e3633db525cd26cfb5f99e";

    public HttpURLConnection connect(String urlString, Map<String, String> parameters) throws IOException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlString);

        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            builder.queryParam(key, value);
        }

        builder.queryParam("units", "metric");
        builder.queryParam("lang", "pt_br");
        builder.queryParam("appid", APP_ID);

        URL url = new URL(builder.build().toString());
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

        httpConnection.setRequestMethod("GET");
        httpConnection.connect();
        return httpConnection;
    }

    public void disconnect(HttpURLConnection connection) {
        if (connection != null) {
            connection.disconnect();
        }
    }

    public String extractJsonFromStream(InputStream inputStream) throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return builder.toString();
    }
}
