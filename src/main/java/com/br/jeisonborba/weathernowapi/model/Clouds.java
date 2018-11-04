package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Clouds {

    @SerializedName("all")
    private float all;
}
