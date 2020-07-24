package org.kek.rest;

import org.kek.backend.enums.Currency;
import org.kek.backend.service.FlightService;
import org.kek.data.dto.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Flight REST controller which produce data from Aviasales API
 *
 * @version 1.01 24 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/aviasales/flights", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AviasalesFlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Get direct flights from aviasales api
     *
     * @param from origin iata
     * @param to destination iata
     * @param date date
     * @param currency currency
     * @return list of flights
     */
    @GetMapping("/direct")
    public List<Flight> getDirectFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam(required = false) String currency
    ) {

        Currency finalCurrency = currency == null || currency.isEmpty()
                ? Currency.USD : Currency.valueOf(currency);

        return flightService.getDirectFlightsFromAviasalesApi(
                from, to, date, finalCurrency
        );
    }

    /**
     * Get cheap flights from aviasales api
     *
     * @param from origin iata
     * @param to destination iata
     * @param date date
     * @param currency currency
     * @return list of flights
     */
    @GetMapping("/cheap")
    public List<Flight> getCheapFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam(required = false) String currency
    ) {

        Currency finalCurrency = currency == null || currency.isEmpty()
                ? Currency.USD : Currency.valueOf(currency);

        return flightService.getCheapFlightsFromAviasalesApi(
                from, to, date, finalCurrency
        );
    }
}
