package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AbstractForecast {

    private long dt;

    @SerializedName("weather")
    private Weather[] weather;

    @SerializedName("main")
    private MainResponse main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;
}
