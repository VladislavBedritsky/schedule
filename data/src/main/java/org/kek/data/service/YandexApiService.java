package org.kek.data.service;

import org.kek.data.dto.Flight;
import org.kek.data.dto.StationFlight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.ResponseTable;
import org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl.Segments;
import org.kek.data.model.yandexApi.domainsForOneStationUrl.Response;

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
     * Convert ResponseTable to FlightsList.
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
     * Convert ResponseTable to Tickets list.
     *
     * @param segment Information about flights found.
     *
     * @return list of tickets
     */
    List<Ticket> convertResponseTableToListOfTickets(Segments segment);

    /**
     * Get all flights by station and date and event.
     *
     * @param stationIataCode Station IATA code (departure)
     * @param date Request date
     * @param event The event for which you want to filter threads
     *              in the schedule ('departure' or 'arrival').
     *
     * @return list of stationFlights
     */
    List<StationFlight> getFlightsByStationIataCodeAndDateAndEvent(
            String stationIataCode, String date, String event);

    /**
     * Convert Response to StationFlights list.
     *
     * @param response  Response info for one station by date from api.rasp.yandex.net REST API.
     * @param stationIataCode Station IATA code
     *
     * @return list of stationFlights
     */
    List<StationFlight> convertResponseToListOfFlights(Response response, String stationIataCode);

}
