package org.kek.data.service;

import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.model.aviationstackApi.AirportResponse;
import org.kek.data.model.aviationstackApi.CityResponse;

import java.util.List;

/**
 *
 * Service with data from aviationstack.com REST API
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface AviationstackApiService {

    /**
     * Get all cities from aviationstack.com REST API
     *
     * @return list of cities
     */
    List<City> getAllCities();

    /**
     * Get all cities from CityResponse.
     *
     * @param cityResponse Cities information from REST
     * @return list of cities
     */
    List<City> convertCityResponseToList(CityResponse cityResponse);

    /**
     * Get all airports from aviationstack.com REST API
     *
     * @return list of airports
     */
    List<Airport> getAllAirports();

    /**
     * Get all airports from AirportResponse.
     *
     * @param airportResponse Airports information from REST
     * @return list of airports
     */
    List<Airport> convertAirportResponseToList(AirportResponse airportResponse);
}
