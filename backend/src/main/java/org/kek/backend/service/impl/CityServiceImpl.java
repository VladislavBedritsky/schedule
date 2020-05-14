package org.kek.backend.service.impl;

import org.kek.backend.dao.CityDao;
import org.kek.backend.service.CityService;
import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.model.rapidApi.CityResponse;
import org.kek.data.service.AviationstackApiService;
import org.kek.data.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private RapidApiService rapidApiService;
    @Autowired
    private AviationstackApiService aviationstackApiService;
    @Autowired
    private CityService cityService;

    @Override
    public void updateCityAlternateNamesByIataCode(String iataCode, String alternateNames) {
        City cityFromDb = cityDao.findCityByName(iataCode);
        cityFromDb.setAlternateNames(alternateNames);
        cityDao.saveCity(cityFromDb);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void updateAlternateNamesInCityCollectionsFromRapidApi() {
        List<City> cities = cityService.findAll();
        for(City city : cities) {
            CityResponse cityResponse = rapidApiService.getCityResponseByIataCode(city.getIataCode());
            if (cityResponse.getAlternateNames() != null) {
                cityService.updateCityAlternateNamesByIataCode(city.getIataCode(), cityResponse.getAlternateNames());
            }
        }
    }

    @Override
    public void saveAllCitiesFromAviationstackApi() {
        for(City city : aviationstackApiService.getAllCities()) {
            cityDao.saveCity(city);
        }
    }


}