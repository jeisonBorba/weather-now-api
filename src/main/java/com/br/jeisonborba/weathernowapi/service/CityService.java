package com.br.jeisonborba.weathernowapi.service;

import com.br.jeisonborba.weathernowapi.model.City;
import com.br.jeisonborba.weathernowapi.model.db.CityDB;

import java.util.List;

public interface CityService {

    Long findOne(String city);

    List<CityDB> listAll();

    CityDB create(City city);

    void delete(Long id);
}
