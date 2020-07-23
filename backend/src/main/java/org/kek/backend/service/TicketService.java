package org.kek.backend.service;

import org.kek.backend.enums.Currency;
import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;

import java.util.List;
import java.util.Map;

/**
 *
 * Ticket Service processes all ticket data
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface TicketService {

    /**
     * Get list of tickets and set them in case of thread numbers from yandex
     * and aviasales api are equal
     *
     * @param flight Flight data from yandex api
     * @param map Map with aviasales flight data
     * @param currency Currency
     * @return list of tickets
     */
    List<Ticket> getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
            Flight flight, Map<String, FlightData> map, Currency currency);

    /**
     * Get ticket with set id, currency and price
     *
     * @param id Ticket id
     * @param currency Ticket currency
     * @param price Ticker price
     * @return ticket
     */
    Ticket getTicketWithSetCurrencyAndPrice(String id, Currency currency, Long price);

}
