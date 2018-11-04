package com.br.jeisonborba.weathernowapi.model.currentWeather;

import com.br.jeisonborba.weathernowapi.model.AbstractWeather;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrentWeather {

    @SerializedName("list")
    private AbstractWeather[] weather;
}
