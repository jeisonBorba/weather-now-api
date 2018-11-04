package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class City {

    private long id;
    private String name;
    private String country;

    @SerializedName("sys")
    private SystemResponse systemResponse;
}
