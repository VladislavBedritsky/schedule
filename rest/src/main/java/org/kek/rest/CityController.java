package org.kek.rest;

import org.kek.backend.service.CityService;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * User REST controller
 *
 * @version 1.01 19 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/api/cities", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities(
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String iataCode
            ) {

        return cityService.getListOfCitiesReferringOnParamValues(cityName, iataCode);
    }

}
