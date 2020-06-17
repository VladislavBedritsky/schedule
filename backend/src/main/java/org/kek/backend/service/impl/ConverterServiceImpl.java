package org.kek.backend.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.kek.backend.model.User;
import org.kek.backend.service.ConverterService;
import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Converter service implementation
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class ConverterServiceImpl implements ConverterService {

    @Override
    public String convertListToJsonString(Object jsonObject) {
        return new Gson().toJson(jsonObject);
    }

    @Override
    public List<User> convertJsonToListOfUsers(String json) {
        return new Gson()
                .fromJson(
                        json, new TypeToken<ArrayList<User>>(){}.getType()
                );
    }

    @Override
    public List<City> convertJsonToListOfCities(String json) {
        return new Gson()
                .fromJson(
                        json, new TypeToken<ArrayList<City>>(){}.getType()
                );
    }

    @Override
    public List<Airport> convertJsonToListOfAirports(String json) {
        return new Gson()
                .fromJson(
                        json, new TypeToken<ArrayList<Airport>>(){}.getType()
                );
    }

}
