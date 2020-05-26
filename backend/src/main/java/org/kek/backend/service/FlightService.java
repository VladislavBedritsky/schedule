package org.kek.backend.service;

import org.kek.data.dto.Flight;

import java.util.List;


/**
 *
 * Flight Service
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface FlightService {

    /**
     * Get all flights between two airports by date.
     *
     * @param departureIataCode Airport IATA code (departure)
     * @param arrivalIataCode Airport IATA code (arrival)
     * @param date Request date
     *
     * @return list of flights
     */
    List<Flight> getFlightsBetweenTwoPointsByDate(String departureIataCode, String arrivalIataCode, String date);
}
