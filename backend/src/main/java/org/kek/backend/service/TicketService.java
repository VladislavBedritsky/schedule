package org.kek.backend.service;

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

    List<Ticket> getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
            Flight flight, Map<String, FlightData> map, String currency);

    Ticket getTicketWithCurrencyAndPriceSet(String id, String currency, Long price);

}
