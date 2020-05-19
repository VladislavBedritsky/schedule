package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.AirportDao;
import org.kek.backend.service.AirportService;
import org.kek.backend.service.CityService;
import org.kek.data.dto.Airport;
import org.kek.data.dto.City;
import org.kek.data.service.AviationstackApiService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class AirportServiceImplTest {

    @InjectMocks
    private AirportService airportService;
    @Mock
    private AirportDao airportDao;
    @Mock
    private AviationstackApiService aviationstackApiService;
    @Mock
    private CityService cityService;

    public AirportServiceImplTest() {
        airportService = new AirportServiceImpl();
    }

    @Test
    public void saveAllAirportsFromAviationstackApi() {
        airportService.saveAllAirportsFromAviationstackApi();
        Mockito.verify(aviationstackApiService, Mockito.times(1))
                .getAllAirports();

        Mockito.doAnswer((Answer) invocation -> {
            airportDao.saveAirport(new Airport());
            return null;
        }).when(aviationstackApiService).getAllAirports();

        Mockito.when(aviationstackApiService.getAllAirports())
            .thenReturn(Stream.of(new Airport()).collect(Collectors.toList()));
        Assert.assertEquals(1, aviationstackApiService.getAllAirports().size());

        Mockito.verify(airportDao, Mockito.times(1))
                .saveAirport(isA(Airport.class));

    }

    @Test
    public void getAirportsByCityIataCode() {

        Mockito.when(airportService.getAirportsByCityIataCode("MOW"))
                .thenReturn(Stream.of(new Airport()).collect(Collectors.toList()));

        Assert.assertEquals(1, airportService.getAirportsByCityIataCode("MOW").size());

        Mockito.verify(airportDao, Mockito.times(1))
                .getAirportsByCityIataCode(isA(String.class));
    }

    @Test
    public void getAirportsByCityName() {
        String cityName = "Brest";

        Mockito.when(cityService.findCitiesByCityName(cityName))
                .thenReturn(Stream.of(new City()).collect(Collectors.toList()));
        Assert.assertEquals(1, cityService.findCitiesByCityName(cityName).size());

        Mockito.when(airportService.getAirportsByCityName(cityName))
                .thenReturn(Stream.of(new Airport()).collect(Collectors.toList()));
        Assert.assertEquals(1, airportService.getAirportsByCityName(cityName).size());

        Mockito.verify(cityService, Mockito.times(3))
                .findCitiesByCityName(isA(String.class));
    }
}