package com.br.jeisonborba.weathernowapi.repository;

import com.br.jeisonborba.weathernowapi.model.db.CityDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<CityDB, Long> {

    Long countByName(String city);

    List<CityDB> findAllByOrderByName();

    void deleteById(Long id);
}
