package org.kek.data.service;

import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.ResponseTable;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Segments;

import java.util.List;

public interface YandexApiService {

    List<Flight> getFlightsBetweenTwoPointsByDate(String departure, String arrival, String date);

    List<Flight> convertResponseTableToListOfFlights(
            ResponseTable responseTable, String fromIataCode, String toIataCode
    );

    List<Ticket> convertResponseTableToListOfTickets(Segments segment);
}
