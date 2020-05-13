package org.kek.data.service.impl;

import org.kek.data.model.aviationstackApi.CityResponse;
import org.kek.data.service.AviationstackApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:url.properties")
public class AviationstackApiServiceImpl implements AviationstackApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.api.aviationstack.findAllCities}")
    private String findAllCitiesUrl;


    @Override
    public CityResponse getResponseWithAllCities() {
        CityResponse cityResponse = restTemplate.getForObject(
                findAllCitiesUrl,
                CityResponse.class);
        return cityResponse;
    }


}
