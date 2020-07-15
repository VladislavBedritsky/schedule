package org.kek.backend.service;

/**
 *
 * DataService is used for working with common data
 *
 * @version 1.01 15 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface DataService {

    /**
     * Fill mongoDB with all data in case of accident
     *
     */
    void fillDbWithData();
}
