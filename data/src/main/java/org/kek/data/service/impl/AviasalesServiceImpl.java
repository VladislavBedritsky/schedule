package org.kek.data.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;
import org.kek.data.model.aviasales.Route;
import org.kek.data.service.AviasalesService;
import org.kek.data.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.*;

/**
 *
 * AviasalesService implementation.
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
@PropertySource("classpath:url.properties")
public class AviasalesServiceImpl implements AviasalesService {

    @Autowired
    private UrlService urlService;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.api.travelpayouts.findFlightsWithCheapPrices}")
    private String findCheapFlightsUrl;
    @Value("${url.api.travelpayouts.findDirectFlightsWithPrices}")
    private String findDirectFlightsUrl;
    @Value("${url.api.travelpayouts.findAllRoutes}")
    private String findAllRoutesUrl;
    @Value("${url.api.travelpayouts.carrierLogo}")
    private String findCarrierLogoUri;

    @Override
    public Map<String, FlightData> getMapOFCheapFlights (
            String pointOriginIataCode,
            String pointDestinationIataCode,
            String date,
            String currency,
            String cityDestinationIataCode
    ) {
        String url = MessageFormat.format(
                findCheapFlightsUrl,
                pointOriginIataCode,
                pointDestinationIataCode,
                date,
                currency);

        Map<String, FlightData> map = parseJsonWithCheapOrDirectFlights(url, cityDestinationIataCode);

        if (map != null) {
            setMapOfFlightsWithAdditionalData(map, pointOriginIataCode, cityDestinationIataCode, currency);
            return map;
        } else {
            return new HashMap<>();
        }

    }

    @Override
    public Map<String, FlightData> getMapOfDirectFlights (
            String pointOriginIataCode,
            String pointDestinationIataCode,
            String date,
            String currency,
            String cityDestinationIataCode
    ) {

        String url = MessageFormat.format(
                findDirectFlightsUrl,
                pointOriginIataCode,
                pointDestinationIataCode,
                date,
                currency);

        Map<String, FlightData> map = parseJsonWithCheapOrDirectFlights(url, cityDestinationIataCode);

        if (map != null) {
            setMapOfFlightsWithAdditionalData(map, pointOriginIataCode, cityDestinationIataCode, currency);
            return map;
        } else {
            return new HashMap<>();
        }
    }

    @Override
    public Map<String, FlightData> parseJsonWithCheapOrDirectFlights(
            String url,
            String cityDestinationIataCode) {

        String json = urlService.getJsonInTypeStringFromRestUrl(url);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;

        try {
            jsonNode = objectMapper.readTree(json);
            String cityJsonNode = jsonNode
                    .path("data")
                    .path(cityDestinationIataCode)
                    .toString();
            jsonNode = objectMapper.readTree(cityJsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return objectMapper
                .convertValue(jsonNode, new TypeReference<HashMap<String, FlightData>>(){});
    }

    @Override
    public List<Route> findAll() {
        ResponseEntity<Route[]> responseEntity =
                restTemplate.getForEntity(
                        findAllRoutesUrl,
                        Route[].class
                );

        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public String getCarrierLogoUri(String airlineIataCode) {
        return MessageFormat.format(
                findCarrierLogoUri, airlineIataCode);
    }

    @Override
    public void setMapOfFlightsWithAdditionalData(
            Map<String, FlightData> map, String originIataCode,
            String destinationIataCode, String currency) {


        for (String key : map.keySet()) {
            FlightData flightData = map.get(key);
            flightData.setCurrency(currency);
            flightData.setOriginIataCode(originIataCode);
            flightData.setDestinationIataCode(destinationIataCode);
            flightData.setCarrierLogoUri(getCarrierLogoUri(flightData.getAirline()));
        }
    }

    @Override
    public List<Flight> convertMapOfFlightDataToListOfFlights(
            Map<String, FlightData> map) {

        ArrayList<Flight> flights = new ArrayList<>();

        for (String key : map.keySet()) {
            FlightData flightData = map.get(key);

            Flight flight = new Flight();
            flight.setId(key);
            flight.setTimeArrival(flightData.getArrivalTime());
            flight.setFromIataCode(flightData.getOriginIataCode());
            flight.setThreadNumber(flightData.getAirline()+" "+flightData.getFlightNumber());
            flight.setCarrierLogoSvg(getCarrierLogoUri(flightData.getAirline()));
            flight.setDepartureTime(flightData.getDepartureTime());
            flight.setToIataCode(flightData.getDestinationIataCode());

            List<Ticket> tickets = new ArrayList<>();
            Ticket ticket = new Ticket();
            ticket.setCurrency(flightData.getCurrency());
            ticket.setWhole(flightData.getPrice());
            ticket.setId(key);
            tickets.add(ticket);

            flight.setTickets(tickets);

            flights.add(flight);
        }

        return flights;
    }
}
