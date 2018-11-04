package com.br.jeisonborba.weathernowapi.model.forecast;

import com.br.jeisonborba.weathernowapi.model.AbstractForecast;
import com.br.jeisonborba.weathernowapi.model.City;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrentForecast {

    @SerializedName("cnt")
    private int count;

    @SerializedName("city")
    private City city;

    @SerializedName("list")
    private AbstractForecast[] forecast;
}
