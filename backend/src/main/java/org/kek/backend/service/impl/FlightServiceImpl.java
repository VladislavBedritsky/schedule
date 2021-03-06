package org.kek.backend.service.impl;

import org.kek.backend.enums.Currency;
import org.kek.backend.service.CityService;
import org.kek.backend.service.FlightService;
import org.kek.backend.service.TicketService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.kek.data.model.aviasales.FlightData;
import org.kek.data.service.AviasalesService;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AviasalesService aviasalesService;

    @Override
    public List<Flight> getDirectFlightsYandexAndAviasalesApi(
            String departureIataCode, String arrivalIataCode, String date, Currency currency) {

        if (currency == null) {
            currency = Currency.USD;
        }

        List<Flight> flights = yandexApiService
                .getFlightsBetweenTwoPointsByDate(departureIataCode, arrivalIataCode, date);

        String cityDestinationIataCode =
                cityService.getCityIataCodeByPointIataCode(arrivalIataCode);

        Map<String, FlightData> directFlightsFromAviasalesApi =
                aviasalesService.getMapOfDirectFlights(
                        departureIataCode,
                        arrivalIataCode,
                        date,
                        currency.toString(),
                        cityDestinationIataCode
                );

        if (directFlightsFromAviasalesApi != null) {
            checkIfFlightTicketsIsEmptyThenFillItWithAviasalesData(
                    flights, currency, directFlightsFromAviasalesApi);
        }

        return flights;
    }

    @Override
    public List<StationFlight> getFlightsByStationIataCodeAndDateAndEvent(
            String stationIataCode, String date, String event) {

        return yandexApiService
                .getFlightsByStationIataCodeAndDateAndEvent(stationIataCode, date, event);
    }

    @Override
    public void checkIfFlightTicketsIsEmptyThenFillItWithAviasalesData(
            List<Flight> flights,
            Currency currency,
            Map<String, FlightData> map) {

        flights.stream()
                .filter(flight ->
                                flight.getTickets().size() == 0)
                .collect(Collectors.toList())
                .forEach(flight ->
                            flight.setTickets(
                                    ticketService
                                            .getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
                                                    flight, map, currency))
                );
    }

    @Override
    public List<Flight> getDirectFlightsFromAviasalesApi (
            String departureIataCode, String arrivalIataCode, String date, Currency currency
    ) {

        String cityDestinationIataCode =
                cityService.getCityIataCodeByPointIataCode(arrivalIataCode);

        Map<String, FlightData> directFlightsFromAviasalesApi =
                aviasalesService.getMapOfDirectFlights(
                        departureIataCode,
                        arrivalIataCode,
                        date,
                        currency.toString(),
                        cityDestinationIataCode
                );

        return aviasalesService.convertMapOfFlightDataToListOfFlights(directFlightsFromAviasalesApi);
    }

    @Override
    public List<Flight> getCheapFlightsFromAviasalesApi (
            String departureIataCode, String arrivalIataCode, String date, Currency currency
    ) {

        String cityDestinationIataCode =
                cityService.getCityIataCodeByPointIataCode(arrivalIataCode);

        Map<String, FlightData> cheapFlightsFromAviasalesApi =
                aviasalesService.getMapOFCheapFlights(
                        departureIataCode,
                        arrivalIataCode,
                        date,
                        currency.toString(),
                        cityDestinationIataCode
                );

        return aviasalesService.convertMapOfFlightDataToListOfFlights(cheapFlightsFromAviasalesApi);
    }

}
