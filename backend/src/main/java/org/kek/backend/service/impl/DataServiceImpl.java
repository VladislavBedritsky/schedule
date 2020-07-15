package org.kek.backend.service.impl;

import org.kek.backend.service.AirportService;
import org.kek.backend.service.CityService;
import org.kek.backend.service.DataService;
import org.kek.data.dto.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * DataService implementation
 *
 * @version 1.01 15 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private AirportService airportService;
    @Autowired
    private CityService cityService;

    @Override
    public void fillDbWithData() {
        cityService.saveAllCitiesFromAviationstackApi();
        airportService.saveAllAirportsFromAviationstackApi();
        airportService.updateCityNameInAirportsCollection();

        Airport zhukovskyAirport = new Airport();
        zhukovskyAirport.setAirportName("Zhukovsky International Airport");
        zhukovskyAirport.setIataCode("ZIA");
        zhukovskyAirport.setIcaoCode("UUBW");
        zhukovskyAirport.setLatitude("55.553299");
        zhukovskyAirport.setLongitude("38.150002");
        zhukovskyAirport.setGeoNameId("");
        zhukovskyAirport.setTimezone("Europe/Moscow");
        zhukovskyAirport.setCountryName("Russia");
        zhukovskyAirport.setCountryIso2("RU");
        zhukovskyAirport.setCityIataCode("MOW");
        zhukovskyAirport.setCityName("Moscow");

        airportService.saveAirport(zhukovskyAirport);
    }
}
