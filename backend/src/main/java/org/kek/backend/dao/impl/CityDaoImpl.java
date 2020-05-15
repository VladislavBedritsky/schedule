package org.kek.backend.dao.impl;

import org.kek.backend.dao.CityDao;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveCity(City city) {
        mongodbTemplate.save(city, "cities");
    }

    @Override
    public List<City> findAll() {
        return mongodbTemplate.findAll(City.class, "cities");
    }

    @Override
    public City findCityById(String id) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("_id").is(id));
        return mongodbTemplate.findOne(query, City.class, "cities");
    }

    @Override
    public City findCityByIataCode(String iataCode) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("iataCode").is(iataCode));
        return mongodbTemplate.findOne(query, City.class, "cities");
    }

}
