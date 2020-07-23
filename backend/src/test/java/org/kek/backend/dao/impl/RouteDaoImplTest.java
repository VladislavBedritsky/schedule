package org.kek.backend.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.RouteDao;
import org.kek.data.model.aviasales.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class RouteDaoImplTest {

    @Autowired
    private RouteDao routeDao;
    @Autowired
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongodbTemplate;

    private Route newRoute;
    private Route routeFromDb;
    private final String airlineIata = "SU";

    @Before
    public void setUp() {
        newRoute = new Route();
        newRoute.setAirlineIata(airlineIata);
        routeFromDb = routeDao.findAll().stream().findFirst().orElse(null);
    }

    @Test
    @Transactional
    public void saveRoute() {
        routeDao.saveRoute(newRoute);
        Query query = new Query().addCriteria(Criteria.where("airlineIata").is(airlineIata));
        List<Route> routes = mongodbTemplate.find(query, Route.class, "routes");

        Assert.assertEquals(1, routes.size());

    }

    @Test
    public void findAll() {
        Assert.assertNotEquals(0, routeDao.findAll().size());
    }
}