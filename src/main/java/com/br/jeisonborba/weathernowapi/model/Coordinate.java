package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Coordinate {

    @SerializedName("lon")
    private float lon;

    @SerializedName("lat")
    private float lat;
}
