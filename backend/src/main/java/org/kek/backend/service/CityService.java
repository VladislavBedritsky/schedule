package org.kek.backend.service;

import org.kek.data.dto.City;

import java.util.List;

/**
 *
 * City Service
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface CityService {

    /**
     * Update cities alternate names in DB by IATA code
     *
     * @param iataCode Cities IATA code
     * @param alternateNames Cities alternate names
     */
    void updateCityAlternateNamesByIataCode(String iataCode, String alternateNames);

    /**
     * Get all cities from DB
     *
     * @return list of cities
     */
    List<City> findAll();

    /**
     * Update cities alternate names in DB with rapidapi.com REST API
     */
    void updateAlternateNamesInCityCollectionsFromRapidApi();

    /**
     * Save all cities to DB from aviationstack.com REST API
     */
    void saveAllCitiesFromAviationstackApi();

    /**
     * Get all cities by cities name.
     *
     * @param cityName Cities name
     * @return list of cities
     */
    List<City> findCitiesByCityName(String cityName);
}
