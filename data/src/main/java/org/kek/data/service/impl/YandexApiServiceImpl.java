package org.kek.data.service.impl;

import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Place;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.ResponseTable;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Segments;
import org.kek.data.model.yandexApi.domainsForOneStationUrl.Response;
import org.kek.data.model.yandexApi.domainsForOneStationUrl.Schedule;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * YandexApiService implementation.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
@PropertySource("classpath:url.properties")
public class YandexApiServiceImpl implements YandexApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.api.yandex.findSegmentsBetweenTwoPointsByDate}")
    private String betweenTwoPointsByDateUri;
    @Value("${url.api.yandex.findSegmentsByStationIataCodeAndDate}")
    private String byStationAndDateAndEventUri;

    @Override
    public List<Flight> getFlightsBetweenTwoPointsByDate(String fromIataCode, String toIataCode, String date) {
        ResponseTable responseTable = restTemplate.getForObject(
                betweenTwoPointsByDateUri,
                ResponseTable.class,
                fromIataCode,
                toIataCode,
                date
        );

        List<Flight> flights = new ArrayList<>();
        if(responseTable != null) {
            flights = convertResponseTableToListOfFlights(
                    responseTable, fromIataCode, toIataCode
            );
        }

        return flights;
    }

    @Override
    public List<Flight> convertResponseTableToListOfFlights(
            ResponseTable responseTable, String fromIataCode, String toIataCode
    ) {

        List<Flight> flights = new ArrayList<>();
        for(Segments segment : responseTable.getSegments()) {
            Flight flight = new Flight();
            flight.setTimeArrival(segment.getArrival());
            flight.setFromIataCode(fromIataCode);
            flight.setFromTitle(segment.getFrom().getTitle());
            flight.setThreadTitle(segment.getThread().getTitle());
            flight.setThreadNumber(segment.getThread().getNumber());
            flight.setThreadMethodLink(segment.getThread().getThreadMethodLink());
            flight.setCarrierEmail(segment.getThread().getCarrier().getEmail());
            flight.setCarrierUrl(segment.getThread().getCarrier().getUrl());
            flight.setCarrierLogoSvg(segment.getThread().getCarrier().getLogoSvg());
            flight.setCarrierTitle(segment.getThread().getCarrier().getTitle());
            flight.setVehicleName(segment.getThread().getVehicle());
            flight.setDepartureTime(segment.getDepartureTime());
            flight.setDepartureTerminal(segment.getDepartureTerminal());
            flight.setToIataCode(toIataCode);
            flight.setToTitle(segment.getTo().getTitle());
            flight.setDuration(segment.getDuration());
            flight.setArrivalTerminal(segment.getArrivalTerminal());
            flight.setStartDate(segment.getStartDate());
            flight.setRequestDate(responseTable.getSearch().getDate());
            flight.setTickets(
                    convertResponseTableToListOfTickets(segment)
            );

            flights.add(flight);
        }

        return flights;
    }

    @Override
    public List<Ticket> convertResponseTableToListOfTickets(Segments segment) {
        List<Ticket> tickets = new ArrayList<>();

        if (segment.getTicketsInfo() != null) {
            for(Place place : segment.getTicketsInfo().getPlaces()) {
                Ticket ticket = new Ticket();
                ticket.setEtMarker(segment.getTicketsInfo().getEtMarker());
                ticket.setName(place.getName());
                ticket.setCurrency(place.getCurrency());
                ticket.setCents(place.getPrice().getCents());
                ticket.setWhole(place.getPrice().getWhole());

                tickets.add(ticket);
            }
        }

        return tickets;
    }

    @Override
    public List<StationFlight> getFlightsByStationIataCodeAndDateAndEvent(
            String stationIataCode, String date, String event) {
        Response response = restTemplate.getForObject(
                byStationAndDateAndEventUri,
                Response.class,
                stationIataCode,
                date,
                event
        );

        List<StationFlight> flights = new ArrayList<>();
        if(response != null) {
            flights = convertResponseToListOfFlights(
                    response, stationIataCode
            );
        }

        return flights;
    }

    @Override
    public List<StationFlight> convertResponseToListOfFlights(Response response, String stationIataCode) {
        List<StationFlight> flights = new ArrayList<>();
        for(Schedule schedule : response.getSchedules()) {
            StationFlight stationFlight = new StationFlight();
            stationFlight.setDate(response.getDate());
            stationFlight.setStationYandexCode(response.getStation().getCode());
            stationFlight.setStationIataCode(stationIataCode);
            stationFlight.setStationTitle(response.getStation().getTitle());
            stationFlight.setPopularTitle(response.getStation().getPopularTitle());
            stationFlight.setExceptDays(schedule.getExceptDays());
            stationFlight.setArrivalTime(schedule.getArrivalTime());
            stationFlight.setThreadTitle(schedule.getThread().getTitle());
            stationFlight.setThreadNumber(schedule.getThread().getNumber());
            stationFlight.setCarrierIataCode(schedule.getThread().getCarrier().getCodes().getIata());
            stationFlight.setCarrierTitle(schedule.getThread().getCarrier().getTitle());
            stationFlight.setVehicle(schedule.getThread().getVehicle());
            stationFlight.setStops(schedule.getStops());
            stationFlight.setDepartureTime(schedule.getDepartureTime());
            stationFlight.setTerminal(schedule.getTerminal());

            flights.add(stationFlight);
        }

        return flights;
    }

}
