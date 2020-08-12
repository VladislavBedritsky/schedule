package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
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
    private CamelContext consumeUsers;
    @Autowired
    @Qualifier("consumeCitiesFromCitiesQueue")
    private CamelContext consumeCities;
    @Autowired
    @Qualifier("consumeAirportsFromAirportsQueue")
    private CamelContext consumeAirports;
    @Autowired
    @Qualifier("consumeCurrencyFromFirstQueue")
    private CamelContext consumeFirstQueue;

    @Override
    public void consumeUsersFromUsersQueue() {
        try {
            consumeUsers.start();
            consumeUsers.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void consumeCitiesFromCitiesQueue() {
        try {
            consumeCities.start();
            Thread.sleep(6000);
            consumeCities.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void consumeAirportsFromAirportsQueue() {
        try {
            consumeAirports.start();
            Thread.sleep(6000);
            consumeAirports.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

}
