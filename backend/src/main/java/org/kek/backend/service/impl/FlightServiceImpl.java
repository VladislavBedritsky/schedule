package org.kek.backend.service.impl;

import org.kek.backend.comparator.SortFlightsByDate;
import org.kek.backend.comparator.SortStationFlightsByDate;
import org.kek.backend.service.CityService;
import org.kek.backend.service.FlightService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        return yandexApiService
                .getFlightsBetweenTwoPointsByDate(departureIataCode, arrivalIataCode, date)
                .stream()
                .sorted(new SortFlightsByDate())
                .collect(Collectors.toList());
    }

    @Override
    public List<StationFlight> getFlightsByStationIataCodeAndDateAndEvent(
            String stationIataCode, String date, String event) {

        return yandexApiService
                .getFlightsByStationIataCodeAndDateAndEvent(stationIataCode, date, event)
                .stream()
                .sorted(new SortStationFlightsByDate())
                .collect(Collectors.toList());
    }

}
