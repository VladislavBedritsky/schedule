package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.CityDao;
import org.kek.backend.service.AirportService;
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

import java.util.Collections;
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
    @Mock
    private AirportService airportService;

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

    @Test
    public void findCitiesByCityName() {
        Mockito.when(cityService.findCitiesByCityName("Brest"))
                .thenReturn(Stream.of(new City()).collect(Collectors.toList()));
        Assert.assertEquals(1, cityService.findCitiesByCityName("Brest").size());

        Mockito.verify(cityDao, Mockito.times(1))
                .findCitiesByCityName(isA(String.class));
    }

    @Test
    public void findCityByIataCode() {
        City city = new City();
        city.setIataCode("iataCode");

        Mockito.when(cityService.findCityByIataCode("iataCode"))
                .thenReturn(city);
        Assert.assertEquals("iataCode", cityService.findCityByIataCode("iataCode").getIataCode());

        Mockito.verify(cityDao, Mockito.times(1))
                .findCityByIataCode(isA(String.class));
    }

    @Test
    public void findCitiesByCityNameAndIataCode() {

        Mockito.when(cityService.findCitiesByCityNameAndIataCode("cityName","iataCode"))
                .thenReturn(Collections.singletonList(new City()));
        Assert.assertEquals(1, cityService
                .findCitiesByCityNameAndIataCode("cityName","iataCode")
                .size()
        );

        Mockito.verify(cityDao, Mockito.times(1))
                .findCitiesByCityNameAndIataCode(isA(String.class), isA(String.class));
    }

    @Test
    public void getListOfCitiesReferringOnParamValues() {
        String cityName = "cityName";
        String iataCode = "iataCode";

        cityService.getListOfCitiesReferringOnParamValues(cityName, iataCode);
        Mockito.verify(cityDao, Mockito.times(1))
                .findCitiesByCityNameAndIataCode(isA(String.class), isA(String.class));

        cityService.getListOfCitiesReferringOnParamValues(cityName, null);
        Mockito.verify(cityDao, Mockito.times(1))
                .findCitiesByCityName(isA(String.class));

        cityService.getListOfCitiesReferringOnParamValues(null, iataCode);
        Mockito.verify(cityDao, Mockito.times(1))
                .findCityByIataCode(isA(String.class));

        cityService.getListOfCitiesReferringOnParamValues(null, null);
        Mockito.verify(cityDao, Mockito.times(1))
                .findAll();
    }

    @Test
    public void getCityNameByCityIataCode() {

        City city = new City();
        city.setIataCode("iataCode");
        city.setCityName("cityName");

        Mockito.when(cityDao.findCityByIataCode("iataCode"))
                .thenReturn(city);
        Assert.assertEquals(city.getCityName(), cityDao.findCityByIataCode("iataCode").getCityName());

        cityService.getCityNameByCityIataCode("iataCode");
        Mockito.verify(cityDao, Mockito.times(2))
                .findCityByIataCode(isA(String.class));
    }

    @Test
    public void getCityIataCodeByPointIataCode() {
        cityService.getCityIataCodeByPointIataCode("airportIataCode");
        Mockito.verify(airportService, Mockito.times(1))
                .findAll();
    }

}