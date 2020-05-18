package org.kek.data.service.impl;

import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.model.aviationstackApi.AirportData;
import org.kek.data.model.aviationstackApi.AirportResponse;
import org.kek.data.model.aviationstackApi.CityData;
import org.kek.data.model.aviationstackApi.CityResponse;
import org.kek.data.service.AviationstackApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * AviationstackApiService implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
@PropertySource("classpath:url.properties")
public class AviationstackApiServiceImpl implements AviationstackApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.api.aviationstack.findAllCities}")
    private String findAllCitiesUrl;
    @Value("${url.api.aviationstack.findAllAirports}")
    private String findAllAirportsUrl;


    @Override
    public List<City> getAllCities() {
        CityResponse cityResponse = restTemplate.getForObject(
                findAllCitiesUrl,
                CityResponse.class);

        List<City> cities = new ArrayList<>();
        if(cityResponse != null) {
            cities = convertCityResponseToList(cityResponse);
        }

        return cities;
    }

    @Override
    public List<City> convertCityResponseToList(CityResponse cityResponse) {
        List<City> cities = new ArrayList<>();
        for(CityData cityData : cityResponse.getData()) {
            City city = new City();
            city.setCityName(cityData.getCityName());
            city.setIataCode(cityData.getIataCode());
            city.setCountryCode(cityData.getCountryIso2());
            city.setLatitude(cityData.getLatitude());
            city.setLongitude(cityData.getLongitude());
            city.setTimezone(cityData.getTimezone());
            city.setAlternateNames(cityData.getCityName());

            cities.add(city);
        }
        return cities;
    }

    @Override
    public List<Airport> getAllAirports() {
        AirportResponse airportResponse = restTemplate.getForObject(
                findAllAirportsUrl,
                AirportResponse.class);

        List<Airport> airports = new ArrayList<>();
        if(airportResponse != null) {
            airports = convertAirportResponseToList(airportResponse);
        }

        return airports;
    }

    @Override
    public List<Airport> convertAirportResponseToList(AirportResponse airportResponse) {
        List<Airport> airports = new ArrayList<>();
        for(AirportData airportData : airportResponse.getData()) {
            Airport airport = new Airport();
            airport.setAirportName(airportData.getAirportName());
            airport.setIataCode(airportData.getIataCode());
            airport.setIcaoCode(airportData.getIcaoCode());
            airport.setLatitude(airportData.getLatitude());
            airport.setLongitude(airportData.getLongitude());
            airport.setGeoNameId(airportData.getGeoNameId());
            airport.setTimezone(airportData.getTimezone());
            airport.setCountryName(airportData.getCountryName());
            airport.setCountryIso2(airportData.getCountryIso2());
            airport.setCityIataCode(airportData.getCityIataCode());

            airports.add(airport);
        }
        return airports;
    }
}
