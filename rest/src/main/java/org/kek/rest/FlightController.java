package org.kek.rest;

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
 * Flight REST controller
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/api/flights", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAll(
            @RequestParam String fromIataCode,
            @RequestParam String toIataCode,
            @RequestParam(required = false) String date) {

        return flightService.getFlightsBetweenTwoPointsByDate(
                fromIataCode, toIataCode, date);

    }
}
