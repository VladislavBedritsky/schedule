package org.kek.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.kek.backend.service.ConverterService;
import org.kek.camel.dto.CityDto;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Processor implementation which transform data in camel route
 * to list of cities
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Component
public class TransformToCitiesList implements Processor {
    @Autowired
    private ConverterService converterService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);

        List<City> cities = converterService.convertJsonToListOfCities(payload);

        List<CityDto> result = cities
                .stream()
                .map(city -> {
                    CityDto cityDto = new CityDto();
                    cityDto.setCityName(city.getCityName());
                    cityDto.setIataCode(city.getIataCode());
                    cityDto.setCountryCode(city.getCountryCode());
                    cityDto.setLatitude(city.getLatitude());
                    cityDto.setLongitude(city.getLongitude());
                    cityDto.setTimezone(city.getTimezone());
                    cityDto.setAlternateNames(city.getAlternateNames());
                    return cityDto;
                })
                .collect(Collectors.toList());

        exchange.getIn().setBody(result);
    }
}
