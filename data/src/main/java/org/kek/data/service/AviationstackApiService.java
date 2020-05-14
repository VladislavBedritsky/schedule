package org.kek.data.service;

import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.model.aviationstackApi.AirportResponse;
import org.kek.data.model.aviationstackApi.CityResponse;

import java.util.List;

public interface AviationstackApiService {

    List<City> getAllCities();

    List<City> convertCityResponseToList(CityResponse cityResponse);

    List<Airport> getAllAirports();

    List<Airport> convertAirportResponseToList(AirportResponse airportResponse);
}
