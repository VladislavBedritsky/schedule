package org.kek.backend.service.impl;

import org.kek.backend.service.CityService;
import org.kek.backend.service.FlightService;
import org.kek.data.dto.Flight;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private YandexApiService yandexApiService;
    @Autowired
    private CityService cityService;


    public List<Flight> getFlightsBetweenTwoPointsByDate(
            String departureCity, String arrivalCity, String date) {

        String departureIataCode = null;
        String arrivalIataCode = null;

        return yandexApiService.getFlightsBetweenTwoPointsByDate(
                departureIataCode, arrivalIataCode, date
        );
    }
}
