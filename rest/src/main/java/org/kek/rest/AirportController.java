package org.kek.rest;

import org.kek.backend.service.AirportService;
import org.kek.data.dto.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * User REST controller
 *
 * @version 1.01 2 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/api/airports", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.findAll();
    }
}
