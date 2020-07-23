package org.kek.backend.service.impl;

import org.kek.backend.dao.RouteDao;
import org.kek.backend.service.RouteService;
import org.kek.data.model.aviasales.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * RouteService implementation
 *
 * @version 1.01 23 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public void saveRoute(Route route) {
        routeDao.saveRoute(route);
    }

    @Override
    public List<Route> findAll() {
        return routeDao.findAll();
    }


}
