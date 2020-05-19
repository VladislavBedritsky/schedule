package org.kek.backend.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.AirportDao;
import org.kek.data.dto.Airport;
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
public class AirportDaoImplTest {

    @Autowired
    private AirportDao airportDao;
    @Autowired
    private MongoTemplate mongodbTemplate;

    private Airport newAirport;
    private Airport airportFromDb;

    @Before
    public void setUp() {
        newAirport = new Airport();
        newAirport.setAirportName("SpringJUnit4");

        airportFromDb = airportDao.findAll().stream().reduce((first,second) -> second).orElse(null);
    }

    @Test
    @Transactional
    public void saveAirport() {
        airportDao.saveAirport(newAirport);
        Query query = new Query().addCriteria(Criteria.where("airportName").is("SpringJUnit4"));
        List<Airport> airports = mongodbTemplate.find(query, Airport.class, "airports");

        assertThat(airports.size(), is(1));
    }

    @Test
    public void findAll() {
        List<Airport> airports = airportDao.findAll();
        assertNotNull(airports);
    }

    @Test
    public void getAirportsByCityIataCode() {
        List<Airport> airports = airportDao.getAirportsByCityIataCode(airportFromDb.getIataCode());
        assertNotNull(airports);
    }
}