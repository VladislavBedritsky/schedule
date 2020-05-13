package org.kek.data.service.impl;

import org.kek.data.dto.City;
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

@Service
@PropertySource("classpath:url.properties")
public class AviationstackApiServiceImpl implements AviationstackApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.api.aviationstack.findAllCities}")
    private String findAllCitiesUrl;


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
}
