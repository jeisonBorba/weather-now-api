package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Wind {

    @SerializedName("speed")
    private float speed;

    @SerializedName("deg")
    private float deg;
}
