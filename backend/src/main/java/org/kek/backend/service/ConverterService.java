package org.kek.backend.service;

import org.kek.backend.model.User;
import org.kek.data.dto.Airport;
import org.kek.data.dto.City;

import java.util.List;


/**
 *
 * Converter service is used for converting data in different ways
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface ConverterService {

    /**
     * Get JSON String from object
     *
     * @param jsonObject Object to convert in JSON
     * @return JSON String
     */
    String convertListToJsonString(Object jsonObject);

    /**
     * Get list of users from JSON String
     *
     * @param json JSON String
     * @return list of users
     */
    List<User> convertJsonToListOfUsers(String json);

    /**
     * Get list of cities from JSON String
     *
     * @param json JSON String
     * @return list of cities
     */
    List<City> convertJsonToListOfCities(String json);

    /**
     * Get list of airports from JSON String
     *
     * @param json JSON String
     * @return list of airports
     */
    List<Airport> convertJsonToListOfAirports(String json);
}
