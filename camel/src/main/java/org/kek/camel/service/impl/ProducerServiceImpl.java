package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.backend.service.AirportService;
import org.kek.backend.service.CityService;
import org.kek.backend.service.ConverterService;
import org.kek.backend.service.UserService;
import org.kek.camel.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private ConverterService converterService;
    @Autowired
    @Qualifier("produceCitiesToScheduleQueue")
    private CamelContext produceCitiesToScheduleQueue;
    @Autowired
    @Qualifier("produceUsersToScheduleQueue")
    private CamelContext produceUsersToScheduleQueue;
    @Autowired
    @Qualifier("produceAirportsToScheduleQueue")
    private CamelContext produceAirportsToScheduleQueue;

    @Override
    public void produceCollectionOfCitiesToScheduleQueue() {
        String message = converterService.convertListToJsonString(
                cityService.findAll()
        );

        try {
            produceCitiesToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceCitiesToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:cities", message);

            produceCitiesToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfAirportsToScheduleQueue() {
        String message = converterService.convertListToJsonString(
                airportService.findAll()
        );

        try {
            produceAirportsToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceAirportsToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:airports", message);

            produceAirportsToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfUsersToScheduleQueue() {
        String message = converterService.convertListToJsonString(
                userService.findAll()
        );

        try {
            produceUsersToScheduleQueue.start();

            ProducerTemplate producerTemplate = produceUsersToScheduleQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:users", message);

            produceUsersToScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
