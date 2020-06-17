package org.kek.camel.process;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.kek.backend.service.ConverterService;
import org.kek.camel.dto.AirportDto;
import org.kek.data.dto.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Processor implementation which transform data in camel route
 * to list of airports
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Component
public class TransformToAirportsList implements Processor {

    @Autowired
    private ConverterService converterService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);

        List<Airport> airports = converterService.convertJsonToListOfAirports(payload);

        List<AirportDto> result = airports
                .stream()
                .map(airport -> {
                    AirportDto airportDto = new AirportDto();
                    airportDto.setAirportName(airport.getAirportName());
                    airportDto.setIataCode(airport.getIataCode());
                    airportDto.setIcaoCode(airport.getIcaoCode());
                    airportDto.setLatitude(airport.getLatitude());
                    airportDto.setLongitude(airport.getLongitude());
                    airportDto.setGeoNameId(airport.getGeoNameId());
                    airportDto.setTimezone(airport.getTimezone());
                    airportDto.setCountryName(airport.getCountryName());
                    airportDto.setCountryIso2(airport.getCountryIso2());
                    airportDto.setCityIataCode(airport.getCityIataCode());
                    airportDto.setCityName(airport.getCityName());
                    return airportDto;
                })
                .collect(Collectors.toList());

        exchange.getIn().setBody(
                result
        );
    }
}
