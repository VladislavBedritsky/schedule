package org.kek.camel.service;

/**
 *
 * Camel context producer service
 *
 * @version 1.01 16 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface ProducerService {

    /**
     * Produce collection of cities from MongoDB to ActiveMQ
     * cities queue
     */
    void produceCollectionOfCitiesToCitiesQueue();

    /**
     * Produce collection of airports from MongoDB to ActiveMQ
     * airports queue
     */
    void produceCollectionOfAirportsToAirportsQueue();

    /**
     * Produce collection of users from MongoDB to ActiveMQ
     * users queue
     */
    void produceCollectionOfUsersToUsersQueue();

}
