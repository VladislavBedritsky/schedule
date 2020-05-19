package org.kek.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.service.CityService;
import org.kek.data.dto.City;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
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
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test-rest.xml"})
public class CityControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private CityController cityController;
    @Mock
    private CityService cityService;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.cityController).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesCityController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("cityController"));
    }

    @Test
    public void givenCitiesURI_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/api/cities"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(cityService, Mockito.times(1))
                .getListOfCitiesReferringOnParamValues(any(), any());

        this.mockMvc.perform(get("/api/cities?cityName="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(cityService, Mockito.times(1))
                .getListOfCitiesReferringOnParamValues(isA(String.class), any());

        this.mockMvc.perform(get("/api/cities?iataCode="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(cityService, Mockito.times(1))
                .getListOfCitiesReferringOnParamValues(any(), isA(String.class));

        this.mockMvc.perform(get("/api/cities?cityName=&iataCode="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(cityService, Mockito.times(1))
                .getListOfCitiesReferringOnParamValues(isA(String.class), isA(String.class));
    }
}