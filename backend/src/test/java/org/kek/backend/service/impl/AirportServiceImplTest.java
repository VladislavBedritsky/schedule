package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.AirportDao;
import org.kek.backend.service.AirportService;
import org.kek.data.dto.Airport;
import org.kek.data.service.AviationstackApiService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

    public AirportServiceImplTest() {
        airportService = new AirportServiceImpl();
    }

    @Test
    public void saveAllAirportsFromAviationstackApi() {
        airportService.saveAllAirportsFromAviationstackApi();

        Mockito.verify(aviationstackApiService, Mockito.times(1))
                .getAllAirports();

        Mockito.when(aviationstackApiService.getAllAirports())
            .thenReturn(Stream.of(new Airport()).collect(Collectors.toList()));

        Assert.assertEquals(1, aviationstackApiService.getAllAirports().size());

    }
}