package org.kek.backend.dao.impl;

import org.kek.backend.dao.AirportDao;
import org.kek.data.dto.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportDaoImpl implements AirportDao {

    @Autowired
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveAirport(Airport airport) {
        mongodbTemplate.save(airport, "airports");
    }

    @Override
    public List<Airport> findAll() {
        return mongodbTemplate.findAll(Airport.class, "airports");
    }
}
