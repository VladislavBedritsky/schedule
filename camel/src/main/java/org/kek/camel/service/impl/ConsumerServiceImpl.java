package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.camel.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * Consumer service implementation
 *
 * @version 1.01 16 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static Logger LOGGER = LogManager.getLogger(ConsumerServiceImpl.class);

    @Autowired
    @Qualifier("consumeUsersFromUsersQueue")
    private CamelContext consumeUsersFromUsersQueue;
    @Autowired
    @Qualifier("consumeCitiesFromCitiesQueue")
    private CamelContext consumeCitiesFromCitiesQueue;
    @Autowired
    @Qualifier("consumeAirportsFromAirportsQueue")
    private CamelContext consumeAirportsFromAirportsQueue;

    @Override
    public void consumeUsersFromUsersQueue() {
        try {
            consumeUsersFromUsersQueue.start();
            consumeUsersFromUsersQueue.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consumeCitiesFromCitiesQueue() {
        try {
            consumeCitiesFromCitiesQueue.start();
            Thread.sleep(6000);
            consumeCitiesFromCitiesQueue.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consumeAirportsFromAirportsQueue() {
        try {
            consumeAirportsFromAirportsQueue.start();
            Thread.sleep(6000);
            consumeAirportsFromAirportsQueue.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
