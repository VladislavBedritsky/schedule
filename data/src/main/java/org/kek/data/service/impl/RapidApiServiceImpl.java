package org.kek.data.service.impl;

import org.kek.data.model.rapidApi.CityResponse;
import org.kek.data.model.rapidApi.RapidApiResponse;
import org.kek.data.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@PropertySource("classpath:url.properties")
public class RapidApiServiceImpl implements RapidApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.api.rapidApi.getCityByIataCode}")
    private String findCityByIataCodeUri;
    @Value("${rapidApi.host}")
    private String rapidApiHost;
    @Value("${rapidApi.key}")
    private String rapidApiKey;

    public CityResponse getCityResponseByIataCode(String iataCode) {

        ResponseEntity<RapidApiResponse> response = restTemplate.exchange(
                findCityByIataCodeUri,
                HttpMethod.GET,
                getHttpEntity(),
                RapidApiResponse.class,
                iataCode);

        if (response.getBody().getResponse() != null) {
            List<CityResponse> cities = response.getBody().getResponse();
            for (CityResponse cityResponse : cities) {
                return cityResponse;
            }
        }


        return new CityResponse();
    }

    public HttpEntity getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("x-rapidapi-key", rapidApiKey);

        return new HttpEntity(headers);
    }

}
