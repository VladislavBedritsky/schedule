package org.kek.backend.dao.impl;

import org.kek.backend.dao.RouteDao;
import org.kek.data.dto.City;
import org.kek.data.model.aviasales.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * RouteDao implementation
 *
 * @version 1.01 23 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Repository
public class RouteDaoImpl implements RouteDao {

    @Autowired
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveRoute(Route route) {
        mongodbTemplate.save(route, "routes");
    }

    @Override
    public List<Route> findAll() {
        return mongodbTemplate.findAll(Route.class, "routes");
    }
}
