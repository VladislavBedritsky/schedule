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
     * Consume data from ActiveMQ Schedule queue
     */
    void consumeDataFromScheduleQueue();
}
