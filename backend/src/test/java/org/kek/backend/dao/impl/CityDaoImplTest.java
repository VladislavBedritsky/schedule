package org.kek.backend.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.CityDao;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class CityDaoImplTest {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private MongoTemplate mongodbTemplate;

    private City newCity;
    private City cityFromDb;

    @Before
    public void setUp() {
        newCity = new City();
        newCity.setCityName("SpringJUnit4");

        cityFromDb = cityDao.findAll().stream().reduce((first,second) -> second).orElse(null);
    }

    @Test
    @Transactional
    public void saveCity() {
        cityDao.saveCity(newCity);
        Query query = new Query().addCriteria(Criteria.where("cityName").is("SpringJUnit4"));
        List<City> cities = mongodbTemplate.find(query, City.class, "cities");

        assertThat(cities.size(), is(1));
    }

    @Test
    public void findAll() {
        List<City> cities = cityDao.findAll();
        assertNotNull(cities);
    }

    @Test
    public void findCityById() {
        assertNotNull(cityFromDb);
        assertNotNull(cityDao.findCityById(cityFromDb.getId()));
    }

    @Test
    public void findCityByIataCode() {
        assertNotNull(cityFromDb);
        assertNotNull(cityDao.findCityByIataCode(cityFromDb.getIataCode()));
    }

    @Test
    public void findCitiesByCityName() {
        List<City> cities = cityDao.findCitiesByCityName(cityFromDb.getCityName());
        assertNotNull(cities);
    }
}