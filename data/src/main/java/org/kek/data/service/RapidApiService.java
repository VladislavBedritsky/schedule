package org.kek.data.service;

import org.kek.data.model.rapidApi.CityResponse;
import org.springframework.http.HttpEntity;

public interface RapidApiService {

    CityResponse getCityResponseByIataCode(String iataCode);

    HttpEntity getHttpEntity();

}
