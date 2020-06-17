package org.kek.backend.dao.impl;

import org.kek.backend.dao.CityDao;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * CityDao implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    @Qualifier("mongodbTemplate")
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

    @Override
    public List<City> findCitiesByCityName(String cityName) {
        Collation collation = Collation.of("en")
                .strength(Collation.ComparisonLevel.primary());
        Query query = new Query();
        query.addCriteria(
                Criteria.where("cityName").is(cityName)).collation(collation);
        return mongodbTemplate.find(query, City.class, "cities");
    }

    @Override
    public List<City> findCitiesByCityNameAndIataCode(String cityName, String iataCode) {
        Collation collation = Collation.of("en")
                .strength(Collation.ComparisonLevel.primary());
        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("cityName").is(cityName),
                        Criteria.where("iataCode").is(iataCode)
                )
        ).collation(collation);

        return mongodbTemplate.find(query, City.class, "cities");
    }

}
