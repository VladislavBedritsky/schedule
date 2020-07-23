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

    /**
     * Get city by IATA code from DB
     *
     * @param iataCode Cities IATA code
     * @return City
     */
    City findCityByIataCode(String iataCode);

    /**
     * Get all cities by city name and IATA code.
     *
     * @param cityName Cities name
     * @param iataCode Cities IATA code
     * @return list of cities
     */
    List<City> findCitiesByCityNameAndIataCode(String cityName, String iataCode);

    /**
     * Get all cities referring on parameters value.
     *
     * @param cityName Cities name
     * @param iataCode Cities IATA code
     * @return list of cities
     */
    List<City> getListOfCitiesReferringOnParamValues(String cityName, String iataCode);

    /**
     * Get city name by city IATA code
     *
     * @param cityIataCode Cities IATA code
     * @return name of city
     */
    String getCityNameByCityIataCode(String cityIataCode);

    /**
     * Get city iata code by airport iata code
     *
     * @param iataCode Airport or city iata code
     * @return City iata code
     */
    String getCityIataCodeByPointIataCode(String iataCode);
}
