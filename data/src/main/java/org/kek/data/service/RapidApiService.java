package org.kek.data.service;

import org.kek.data.model.rapidApi.CityResponse;
import org.springframework.http.HttpEntity;

/**
 *
 * Service with data from rapidapi.com REST API
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface RapidApiService {

    /**
     * Get city information by IATA code
     *
     * @param iataCode City IATA code
     * @return CityResponse
     */
    CityResponse getCityResponseByIataCode(String iataCode);

    /**
     * Get HttpEntity with set HttpHeaders
     *
     * @return HttpEntity
     */
    HttpEntity getHttpEntity();

}
