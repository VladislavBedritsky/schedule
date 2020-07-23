package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.enums.Currency;
import org.kek.backend.service.TicketService;
import org.kek.data.dto.Flight;
import org.kek.data.dto.Ticket;
import org.kek.data.model.aviasales.FlightData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;
    private Map<String, FlightData> map;
    private Currency currency;
    private Flight flight;
    private Long price = 443L;
    private Long flightNumber = 123L;
    private String airline = "SU";
    private String id = "0";

    @Before
    public void setUp() {
        currency = Currency.USD;
        FlightData flightData = new FlightData();
        flightData.setAirline(airline);
        flightData.setFlightNumber(flightNumber);
        flightData.setPrice(price);
        map = Collections.singletonMap(id, flightData);

        flight = new Flight();
        flight.setThreadNumber("SU 123");
    }

    @Test
    public void getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual() {
        List<Ticket> tickets = ticketService.getTicketsIfThreadNumbersFromYandexAndAviasalesApiAreEqual(
                flight, map, currency
        );

        Assert.assertEquals(1, tickets.size());

        Ticket ticket = tickets.stream().findFirst().orElse(null);


        Assert.assertNotNull(ticket);
        Assert.assertEquals("0", ticket.getId());
        Assert.assertEquals(price, ticket.getWhole());
        Assert.assertEquals(currency, Currency.valueOf(ticket.getCurrency()));

    }

    @Test
    public void getTicketWithSetCurrencyAndPrice() {
        Ticket newTicket = new Ticket();
        newTicket.setId(id);
        newTicket.setWhole(price);
        newTicket.setCurrency(currency.toString());

        Assert.assertEquals(id, newTicket.getId());
        Assert.assertEquals(price, newTicket.getWhole());
        Assert.assertEquals(currency, Currency.valueOf(newTicket.getCurrency()));
    }
}