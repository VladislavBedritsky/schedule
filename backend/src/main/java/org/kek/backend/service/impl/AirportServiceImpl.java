package org.kek.backend.service.impl;

import org.kek.backend.dao.AirportDao;
import org.kek.backend.service.AirportService;
import org.kek.backend.service.CityService;
import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.service.AviationstackApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * AirportService implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDao airportDao;
    @Autowired
    private AviationstackApiService aviationstackApiService;
    @Autowired
    private CityService cityService;

    @Override
    public void saveAllAirportsFromAviationstackApi() {
        for(Airport airport : aviationstackApiService.getAllAirports()) {
            airportDao.saveAirport(airport);
        }
    }

    @Override
    public List<Airport> getAirportsByCityIataCode(String iataCode) {
        return airportDao.getAirportsByCityIataCode(iataCode);
    }

    @Override
    public List<Airport> getAirportsByCityName(String cityName) {
        List<Airport> result = new ArrayList<>();
        for (City city : cityService.findCitiesByCityName(cityName)) {
            result.addAll(getAirportsByCityIataCode(city.getIataCode()));
        }
        return result;
    }

    @Override
    public List<Airport> findAll() {
        return airportDao.findAll();
    }

    @Override
    public void updateCityNameInAirportsCollection() {

        for (Airport airport : airportDao.findAll()) {
            airport.setCityName(
                cityService.getCityNameByCityIataCode(airport.getCityIataCode())
            );

            airportDao.saveAirport(airport);
        }
    }

}
