package org.kek.backend.dao;

import org.kek.data.dto.Airport;

import java.util.List;

/**
 *
 * Airport DAO
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface AirportDao {
    /**
     * Save Airport to DB
     *
     * @param airport Airport
     */
    void saveAirport(Airport airport);

    /**
     * Get all airports from DB
     *
     * @return list of airports
     */
    List<Airport> findAll();
}
