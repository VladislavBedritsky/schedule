package org.kek.backend.service;

import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;

import java.util.List;
import java.util.Map;


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
     * @param currency currency
     *
     * @return list of flights
     */
    List<Flight> getDirectFlightsBetweenTwoStationsByDate(
            String departureIataCode, String arrivalIataCode, String date, String currency);

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


    void checkIfFlightTicketsIsEmptyThenFillItWithAviasalesData(
            List<Flight> flights,
            String departureIataCode,
            String arrivalIataCode,
            String date,
            String currency,
            Map<String, FlightData> map
    );



}
