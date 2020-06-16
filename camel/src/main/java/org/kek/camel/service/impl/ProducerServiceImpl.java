package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.backend.model.User;
import org.kek.backend.service.AirportService;
import org.kek.backend.service.CityService;
import org.kek.backend.service.UserService;
import org.kek.camel.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * Producer service implementation
 *
 * @version 1.01 16 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static Logger LOGGER = LogManager.getLogger(ProducerServiceImpl.class);

    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private UserService userService;
    @Autowired
    private CamelContext produceDataToScheduleQueue;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void produceCollectionOfCitiesToScheduleQueue() {
        try {
            produceDataToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceDataToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:start", cityService.findAll());

            produceDataToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfAirportsToScheduleQueue() {
        try {
            produceDataToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceDataToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:start", airportService.findAll());

            produceDataToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfUsersToScheduleQueue() {
        try {
            produceDataToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceDataToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:start", userService.findAll());

            produceDataToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
