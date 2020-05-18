package org.kek.data.service;

import org.kek.data.dto.Flight;

import java.util.List;

public interface YandexApiService {

    List<Flight> getFlightsBetweenTwoPointsByDate(String departure, String arrival, String date);
}
