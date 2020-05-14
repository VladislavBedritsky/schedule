package org.kek.backend.service;

import org.kek.data.dto.City;

import java.util.List;

public interface CityService {

    void updateCityAlternateNamesByIataCode(String iataCode, String alternateNames);

    List<City> findAll();

    void updateAlternateNamesInCityCollectionsFromRapidApi();

    void saveAllCitiesFromAviationstackApi();
}
