package org.kek.camel.service;

/**
 *
 * Camel context consumer service
 *
 * @version 1.01 16 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface ConsumerService {

    /**
     * Consume users from ActiveMQ users queue
     */
    void consumeUsersFromUsersQueue();

    /**
     * Consume cities from ActiveMQ cities queue
     */
    void consumeCitiesFromCitiesQueue();
}
