package org.kek.backend.dao.impl;

import org.kek.backend.dao.AirportDao;
import org.kek.data.dto.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * AirportDAO implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Repository
public class AirportDaoImpl implements AirportDao {

    @Autowired
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveAirport(Airport airport) {
        mongodbTemplate.save(airport, "airports");
    }

    @Override
    public List<Airport> findAll() {
        return mongodbTemplate.findAll(Airport.class, "airports");
    }

    @Override
    public List<Airport> getAirportsByCityIataCode(String iataCode) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cityIataCode").is(iataCode));
        return mongodbTemplate.find(query, Airport.class, "airports");
    }
}
