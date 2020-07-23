package org.kek.backend.service;

import org.kek.data.model.aviasales.Route;

import java.util.List;

/**
 *
 * Route service processes all routes data
 *
 * @version 1.01 23 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface RouteService {

    /**
     * Save route into mongodb
     *
     * @param route Route
     */
    void saveRoute(Route route);

    /**
     * Find all routes
     *
     * @return list of routes
     */
    List<Route> findAll();

}
