package com.br.jeisonborba.weathernowapi.service.impl;

import com.br.jeisonborba.weathernowapi.model.City;
import com.br.jeisonborba.weathernowapi.model.db.CityDB;
import com.br.jeisonborba.weathernowapi.repository.CityRepository;
import com.br.jeisonborba.weathernowapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Long findOne(String city) {
        return cityRepository.countByName(city);
    }

    @Override
    public List<CityDB> listAll() {
        return cityRepository.findAllByOrderByName();
    }

    @Override
    public CityDB create(City city) {
        CityDB cityDB = new CityDB();
        cityDB.setExternalId(city.getId());
        cityDB.setName(city.getName());
        cityDB.setCountry(city.getSystemResponse().getCountry());
        return cityRepository.save(cityDB);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
