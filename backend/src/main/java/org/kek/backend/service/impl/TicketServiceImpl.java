package org.kek.backend.service.impl;

import org.kek.backend.enums.Currency;
import org.kek.backend.service.TicketService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TicketService implementation
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public List<Ticket> getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
            Flight flight, Map<String, FlightData> map, Currency currency) {

        List<Ticket> tickets = new ArrayList<>();

        for (String key : map.keySet()) {

            StringBuilder threadNumber = new StringBuilder();

            String airline = map
                    .get(key)
                    .getAirline();
            Long flightNumber = map
                    .get(key)
                    .getFlightNumber();
            Long price = map
                    .get(key)
                    .getPrice();

            threadNumber.append(airline).append(" ").append(flightNumber.toString());

            if (threadNumber.toString().equalsIgnoreCase(flight.getThreadNumber())) {
                Ticket ticket = getTicketWithCurrencyAndPriceSet(
                        key, currency, price);
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    @Override
    public Ticket getTicketWithCurrencyAndPriceSet(String id, Currency currency, Long price) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setCurrency(currency.toString());
        ticket.setWhole(price);
        return ticket;
    }
}
