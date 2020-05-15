package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.CityDao;
import org.kek.backend.service.CityService;
import org.kek.data.dto.City;
import org.kek.data.service.AviationstackApiService;
import org.kek.data.service.RapidApiService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class CityServiceImplTest {

    @InjectMocks
    private CityService cityService;
    @Mock
    private CityDao cityDao;
    @Mock
    private RapidApiService rapidApiService;
    @Mock
    private AviationstackApiService aviationstackApiService;

    public CityServiceImplTest() {
        cityService = new CityServiceImpl();
    }

    @Test
    public void updateCityAlternateNamesByIataCode() {
        String iataCode = "iataCode";

        Mockito.doAnswer((Answer) invocation -> {
            String arg0 = invocation.getArgument(0);
            City city = new City();
            city.setIataCode(arg0);
            city.setAlternateNames("alternateNames");
            return city;
        }).when(cityDao).findCityByIataCode(any(String.class));

        cityService.updateCityAlternateNamesByIataCode(iataCode, "alternateNames");
        Mockito.verify(cityDao, Mockito.times(1))
                .findCityByIataCode(iataCode);
        Mockito.verify(cityDao, Mockito.times(1))
                .saveCity(isA(City.class));
    }

    @Test
    public void findAll() {
        cityService.findAll();
        Mockito.verify(cityDao, Mockito.times(1))
                .findAll();
    }

    @Test
    public void updateAlternateNamesInCityCollectionsFromRapidApi() {
        cityService.updateAlternateNamesInCityCollectionsFromRapidApi();
        Mockito.verify(cityDao, Mockito.times(1))
                .findAll();
    }

    @Test
    public void saveAllCitiesFromAviationstackApi() {
        cityService.saveAllCitiesFromAviationstackApi();
        Mockito.verify(aviationstackApiService, Mockito.times(1))
            .getAllCities();

        Mockito.doAnswer((Answer) invocation -> {
            cityDao.saveCity(new City());
            return null;
        }).when(aviationstackApiService).getAllCities();

        Mockito.when(aviationstackApiService.getAllCities())
                .thenReturn(Stream.of(new City()).collect(Collectors.toList()));
        Assert.assertEquals(1, aviationstackApiService.getAllCities().size());

        Mockito.verify(cityDao, Mockito.times(1))
                .saveCity(isA(City.class));
    }
}