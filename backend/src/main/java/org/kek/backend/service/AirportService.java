package org.kek.backend.service;

/**
 *
 * Airport Service
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface AirportService {

    /**
     * Save all airports from aviationstack.com REST API to DB
     */
    void saveAllAirportsFromAviationstackApi();
}
