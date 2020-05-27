package org.kek.backend.service;

import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;

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

    /**
     * Get all flights by station and date and event.
     *
     * @param stationIataCode Station IATA code (departure)
     * @param date Request date
     * @param event The event for which you want to filter threads
     *              in the schedule ('departure' or 'arrival').
     *
     * @return list of stationFlights
     */
    List<StationFlight> getFlightsByStationIataCodeAndDateAndEvent(
            String stationIataCode, String date, String event);

}
