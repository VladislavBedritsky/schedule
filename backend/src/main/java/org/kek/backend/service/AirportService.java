package org.kek.backend.service;

import org.kek.data.dto.Airport;

import java.util.List;

/**
 *
 * Airport Service
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface AirportService {

    /**
     * Save all airports from aviationstack.com REST API to DB
     */
    void saveAllAirportsFromAviationstackApi();

    /**
     * Get all airports in city by cities IATA code.
     *
     * @param iataCode Cities IATA code
     * @return list of airports
     */
    List<Airport> getAirportsByCityIataCode(String iataCode);

    /**
     * Get all airports in cities by city name.
     *
     * @param cityName Cities IATA code
     * @return list of airports
     */
    List<Airport> getAirportsByCityName(String cityName);

    /**
     * Get all airports.
     *
     * @return list of airports
     */
    List<Airport> findAll();
}
