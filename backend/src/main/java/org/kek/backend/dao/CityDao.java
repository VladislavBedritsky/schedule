package org.kek.backend.dao;

import org.kek.data.dto.City;

import java.util.List;

/**
 *
 * Airport DAO
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface CityDao {

    /**
     * Save city to DB
     *
     * @param city City model
     */
    void saveCity(City city);

    /**
     * Get all cities from DB
     *
     * @return list of cities
     */
    List<City> findAll();

    /**
     * Get city by id from DB
     *
     * @param id Cities id
     * @return City
     */
    City findCityById(String id);

    /**
     * Get city by IATA code from DB
     *
     * @param iataCode Cities IATA code
     * @return City
     */
    City findCityByIataCode(String iataCode);

    /**
     * Get all cities by cities name.
     *
     * @param cityName Cities name
     * @return list of cities
     */
    List<City> findCitiesByCityName(String cityName);
}
