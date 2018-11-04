package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AbstractWeather {

    private String name;
    private long dt;
    private long id;

    @SerializedName("weather")
    private Weather[] weather;

    @SerializedName("main")
    private MainResponse main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("sys")
    private SystemResponse systemResponse;
}
