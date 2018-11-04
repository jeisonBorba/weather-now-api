package com.br.jeisonborba.weathernowapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SystemResponse {

    @SerializedName("type")
    private long type;

    @SerializedName("id")
    private long id;

    @SerializedName("message")
    private double message;

    @SerializedName("country")
    private String country;
}
