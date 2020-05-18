package org.kek.data.service;

import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.ResponseTable;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Segments;

import java.util.List;

/**
 *
 * Service with data from yandex REST API
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface YandexApiService {

    /**
     * Get all flights between two airports by date.
     *
     * @param departure Airport IATA code (departure)
     * @param arrival Airport IATA code (arrival)
     * @param date Request date
     *
     * @return list of flights
     */
    List<Flight> getFlightsBetweenTwoPointsByDate(String departure, String arrival, String date);

    /**
     * Get all flights from ResponseTable.
     *
     * @param responseTable Response between two points by date from api.rasp.yandex.net REST API
     * @param fromIataCode Airport IATA code (departure)
     * @param toIataCode Airport IATA code (arrival)
     *
     * @return list of flights
     */
    List<Flight> convertResponseTableToListOfFlights(
            ResponseTable responseTable, String fromIataCode, String toIataCode
    );

    /**
     * Get all tickets from ResponseTable.
     *
     * @param segment Information about flights found.
     *
     * @return list of tickets
     */
    List<Ticket> convertResponseTableToListOfTickets(Segments segment);
}
