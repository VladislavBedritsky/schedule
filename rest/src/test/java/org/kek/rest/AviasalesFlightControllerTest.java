package org.kek.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.enums.Currency;
import org.kek.backend.service.FlightService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test-rest.xml"})
public class AviasalesFlightControllerTest {


    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private AviasalesFlightController aviasalesFlightController;
    @Mock
    private FlightService flightService;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.aviasalesFlightController).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesCityController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("aviasalesFlightController"));
    }

    @Test
    public void givenDirectFlightsUri_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/aviasales/flights/direct?from=&to=&date="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(flightService, Mockito.times(1))
                .getDirectFlightsFromAviasalesApi(
                        isA(String.class), isA(String.class), isA(String.class), any());


        this.mockMvc.perform(get("/aviasales/flights/direct?from=&to=&date=&currency="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(flightService, Mockito.times(2))
                .getDirectFlightsFromAviasalesApi(
                        isA(String.class), isA(String.class), isA(String.class), isA(Currency.class));
    }

    @Test
    public void givenCheapFlightsUri_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/aviasales/flights/cheap?from=&to=&date="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(flightService, Mockito.times(1))
                .getCheapFlightsFromAviasalesApi(
                        isA(String.class), isA(String.class), isA(String.class), any());


        this.mockMvc.perform(get("/aviasales/flights/cheap?from=&to=&date=&currency="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(flightService, Mockito.times(2))
                .getCheapFlightsFromAviasalesApi(
                        isA(String.class), isA(String.class), isA(String.class), isA(Currency.class));
    }
}