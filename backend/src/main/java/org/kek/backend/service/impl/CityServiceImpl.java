package org.kek.backend.service.impl;

import org.kek.backend.dao.CityDao;
import org.kek.backend.service.CityService;
import org.kek.data.dto.City;
import org.kek.data.model.rapidApi.CityResponse;
import org.kek.data.service.AviationstackApiService;
import org.kek.data.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 *
 * CityService implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private RapidApiService rapidApiService;
    @Autowired
    private AviationstackApiService aviationstackApiService;

    @Override
    public void updateCityAlternateNamesByIataCode(String iataCode, String alternateNames) {
        City cityFromDb = cityDao.findCityByIataCode(iataCode);
        cityFromDb.setAlternateNames(alternateNames);
        cityDao.saveCity(cityFromDb);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void updateAlternateNamesInCityCollectionsFromRapidApi() {
        List<City> cities = cityDao.findAll();
        for(City city : cities) {
            CityResponse cityResponse = rapidApiService.getCityResponseByIataCode(city.getIataCode());
            if (cityResponse.getAlternateNames() != null) {
                updateCityAlternateNamesByIataCode(city.getIataCode(), cityResponse.getAlternateNames());
            }
        }
    }

    @Override
    public void saveAllCitiesFromAviationstackApi() {
        for(City city : aviationstackApiService.getAllCities()) {
            cityDao.saveCity(city);
        }
    }

    @Override
    public List<City> findCitiesByCityName(String cityName) {
        return cityDao.findCitiesByCityName(cityName);
    }

    @Override
    public City findCityByIataCode(String iataCode) {
        return cityDao.findCityByIataCode(iataCode);
    }

    @Override
    public List<City> findCitiesByCityNameAndIataCode(String cityName, String iataCode) {
        return cityDao.findCitiesByCityNameAndIataCode(cityName, iataCode);
    }

    @Override
    public List<City> getListOfCitiesReferringOnParamValues(String cityName, String iataCode) {
        if (cityName != null && iataCode == null) {
            return findCitiesByCityName(cityName);
        } else if (iataCode != null && cityName == null) {
            return Collections.singletonList(findCityByIataCode(iataCode));
        } else if (cityName != null && iataCode != null) {
            return findCitiesByCityNameAndIataCode(cityName, iataCode);
        } else {
            return findAll();
        }
    }


}
