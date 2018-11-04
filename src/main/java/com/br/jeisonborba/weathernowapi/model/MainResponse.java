package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MainResponse {

    @SerializedName("temp")
    private double temperature;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("temp_min")
    private double minimunTemperature;

    @SerializedName("temp_max")
    private double maximunTemperature;
}
