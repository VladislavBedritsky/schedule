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
     * Produce collection of cities from mongoDB to activeMQ
     * schedule_queue
     */
    void produceCollectionOfCitiesToScheduleQueue();

    /**
     * Produce collection of airports from mongoDB to activeMQ
     * schedule_queue
     */
    void produceCollectionOfAirportsToScheduleQueue();

    /**
     * Produce collection of users from mongoDB to activeMQ
     * schedule_queue
     */
    void produceCollectionOfUsersToScheduleQueue();

}
