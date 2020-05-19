package org.kek.data.service.impl;

import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Place;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.ResponseTable;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Segments;
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




}