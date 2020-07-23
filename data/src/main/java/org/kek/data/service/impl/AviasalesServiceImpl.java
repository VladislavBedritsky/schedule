package org.kek.data.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public Map<String, FlightData> getCheapFlights (
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
        String json = urlService.getJsonInTypeStringFromRestUrl(url);

        Map<String, FlightData> result = new HashMap<>();
        try {
            result = parseJsonWithCheapOrDirectFlights(
                    json, cityDestinationIataCode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, FlightData> getDirectFlights (
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
        String json = urlService.getJsonInTypeStringFromRestUrl(url);

        Map<String, FlightData> result = new HashMap<>();
        try {
            result = parseJsonWithCheapOrDirectFlights(
                    json, cityDestinationIataCode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, FlightData> parseJsonWithCheapOrDirectFlights(
            String json,
            String cityDestinationIataCode)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        String cityJsonNode = jsonNode
                .path("data")
                .path(cityDestinationIataCode)
                .toString();
        jsonNode = objectMapper.readTree(cityJsonNode);

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
}
