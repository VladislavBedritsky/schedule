package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.enums.Currency;
import org.kek.backend.service.CityService;
import org.kek.backend.service.FlightService;
import org.kek.backend.service.TicketService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;
import org.kek.data.service.AviasalesService;
import org.kek.data.service.YandexApiService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class FlightServiceImplTest {

    @InjectMocks
    private FlightService flightService;
    @Mock
    private YandexApiService yandexApiService;
    @Mock
    private CityService cityService;
    @Mock
    private AviasalesService aviasalesService;
    @Mock
    private TicketService ticketService;

    private final String DEPARTURE_IATA = "FROM";
    private final String ARRIVAL_IATA = "TO";
    private final String DATE = "2020-07-25";
    private final Currency CURRENCY = Currency.USD;
    private Flight flight = new Flight();
    private Ticket ticket = new Ticket();
    private String cityDestinationIataCode = "cityIata";
    private List<Flight> list = Collections.singletonList(flight);
    private Map<String, FlightData> map = Collections.singletonMap("0", new FlightData());
    private List<Ticket> tickets = Collections.singletonList(ticket);

    public FlightServiceImplTest() {
        flightService = new FlightServiceImpl();
        flight.setTickets(new ArrayList<Ticket>());
    }

    @Test
    public void getDirectFlightsYandexAndAviasalesApi() {

        Mockito.when(yandexApiService.getFlightsBetweenTwoPointsByDate(DEPARTURE_IATA, ARRIVAL_IATA, DATE))
                .thenReturn(list);
        Assert.assertEquals(
                1,
                yandexApiService
                    .getFlightsBetweenTwoPointsByDate(DEPARTURE_IATA, ARRIVAL_IATA, DATE)
                    .size()
        );

        Mockito.when(cityService.getCityIataCodeByPointIataCode(ARRIVAL_IATA))
                .thenReturn(cityDestinationIataCode);
        Assert.assertEquals(
                cityDestinationIataCode,
                cityService.getCityIataCodeByPointIataCode(ARRIVAL_IATA)
        );

        Mockito.when(aviasalesService.getDirectFlights(
                DEPARTURE_IATA, ARRIVAL_IATA,
                DATE, CURRENCY.toString(), cityDestinationIataCode))
                .thenReturn(map);
        Assert.assertEquals(
                1,
                aviasalesService.getDirectFlights(
                        DEPARTURE_IATA, ARRIVAL_IATA,
                        DATE, CURRENCY.toString(), cityDestinationIataCode)
                        .size()
        );


        flightService.getDirectFlightsYandexAndAviasalesApi(
                DEPARTURE_IATA, ARRIVAL_IATA, DATE, CURRENCY);

        Mockito.verify(yandexApiService, Mockito.times(2))
                .getFlightsBetweenTwoPointsByDate(DEPARTURE_IATA, ARRIVAL_IATA, DATE);
        Mockito.verify(cityService, Mockito.times(2))
                .getCityIataCodeByPointIataCode(ARRIVAL_IATA);
        Mockito.verify(aviasalesService, Mockito.times(2))
                .getDirectFlights(
                        DEPARTURE_IATA, ARRIVAL_IATA,
                        DATE, CURRENCY.toString(), cityDestinationIataCode);
        Mockito.verify(ticketService, Mockito.times(1))
                .getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
                        flight, map, CURRENCY);
    }

    @Test
    public void getFlightsByStationIataCodeAndDateAndEvent() {
        flightService.getFlightsByStationIataCodeAndDateAndEvent("code","date","event");
        Mockito.verify(yandexApiService, Mockito.times(1))
                .getFlightsByStationIataCodeAndDateAndEvent(
                        isA(String.class), isA(String.class), isA(String.class)
                );
    }


    @Test
    public void checkIfFlightTicketsIsEmptyThenFillItWithAviasalesData() {
        flightService
                .checkIfFlightTicketsIsEmptyThenFillItWithAviasalesData(
                        list, CURRENCY, map
                );
        Mockito.verify(ticketService, Mockito.times(1))
                .getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
                        flight, map, CURRENCY);
    }
}