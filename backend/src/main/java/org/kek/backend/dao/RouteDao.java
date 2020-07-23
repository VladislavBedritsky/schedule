package org.kek.backend.dao;

import org.kek.data.model.aviasales.Route;

import java.util.List;

/**
 *
 * Route DAO
 *
 * @version 1.01 23 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface RouteDao {

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
