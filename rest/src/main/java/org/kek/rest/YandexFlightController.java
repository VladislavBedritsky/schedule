package org.kek.rest;

import org.kek.backend.service.FlightService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Flight REST controller which produce data from Yandex API
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/yandex/flights", produces = {MediaType.APPLICATION_JSON_VALUE})
public class YandexFlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Get list of flights between two stations by date and stations IATA code.
     *
     * @param fromIataCode Departure station IATA code
     * @param toIataCode Arrival station IATA code
     * @param date Request date
     * @return list of flights
     */
    @GetMapping("/direct")
    public List<Flight> getDirectFlightsBetweenTwoStationsByDate (
            @RequestParam String fromIataCode,
            @RequestParam String toIataCode,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String currency) {

        return flightService.getDirectFlightsYandexAndAviasalesApi(
                fromIataCode, toIataCode, date, currency);

    }

    /**
     * Get list of flights by station and date and event.
     *
     * @param iataCode Station IATA code
     * @param event The event for which you want to filter threads
     *              in the schedule ('departure' or 'arrival')
     * @param date Request date
     * @return list of flights
     */
    @GetMapping("/station")
    public List<StationFlight> getFlightsByStationAndDateAndEvent (
            @RequestParam String iataCode,
            @RequestParam String date,
            @RequestParam String event) {

        return flightService.getFlightsByStationIataCodeAndDateAndEvent(
                iataCode, date, event);
    }

}
