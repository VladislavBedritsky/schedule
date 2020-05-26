package org.kek.backend.service.impl;

import org.kek.backend.service.CityService;
import org.kek.backend.service.FlightService;
import org.kek.data.dto.Flight;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FlightService implementation
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private YandexApiService yandexApiService;
    @Autowired
    private CityService cityService;

    @Override
    public List<Flight> getFlightsBetweenTwoPointsByDate(
            String departureIataCode, String arrivalIataCode, String date) {

        return yandexApiService.getFlightsBetweenTwoPointsByDate(
                departureIataCode, arrivalIataCode, date
        );
    }
}
