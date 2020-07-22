package org.kek.data.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.kek.data.model.aviasales.FlightData;

import java.util.Map;

/**
 *
 * Service which processes data from aviasales API
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface AviasalesService {

    /**
     * Get map with cheap flights from aviasales Api.
     *
     * @param pointOriginIataCode origin point(city, airport, etc.) IATA code
     * @param pointDestinationIataCode destination point(city, airport, etc.) IATA code
     * @param date date
     * @param currency currency
     * @param cityDestinationIataCode destination city IATA code
     * @return Map with FlightData as a value and string as a key (e.g. '0','1','2', ...).
     */
    Map<String, FlightData> getCheapFlights(
            String pointOriginIataCode,
            String pointDestinationIataCode,
            String date,
            String currency,
            String cityDestinationIataCode
    );

    /**
     * Get map with direct flights from aviasales Api.
     *
     * @param pointOriginIataCode origin point(city, airport, etc.) IATA code
     * @param pointDestinationIataCode destination point(city, airport, etc.) IATA code
     * @param date date
     * @param currency currency
     * @param cityDestinationIataCode destination city IATA code
     * @return Map with FlightData as a value and string as a key (e.g. '0','1','2', ...).
     */
    Map<String, FlightData> getDirectFlights (
            String pointOriginIataCode,
            String pointDestinationIataCode,
            String date,
            String currency,
            String cityDestinationIataCode
    );

    /**
     * Function is parsing json in type String from aviasales API into Map.
     * Can be used for cheap or direct flights requests.
     *
     * @param json json in type String
     * @param cityDestinationIataCode destination city IATA code
     *
     * @return Map with FlightData as a value and string as a key (e.g. '0','1','2', ...).
     * @throws JsonProcessingException
     */
    Map<String, FlightData> parseJsonWithCheapOrDirectFlights(
            String json,
            String cityDestinationIataCode)
            throws JsonProcessingException;
}
