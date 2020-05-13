package org.kek.backend.dao;

import org.kek.data.dto.City;

import java.util.List;

public interface CityDao {

    void saveCity(City city);

    List<City> findAll();

    City findCityById(String id);

}
