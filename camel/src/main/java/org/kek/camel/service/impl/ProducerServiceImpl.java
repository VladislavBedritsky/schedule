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
    @Qualifier("produceCitiesToCitiesQueue")
    private CamelContext produceCitiesToCitiesQueue;
    @Autowired
    @Qualifier("produceUsersToUsersQueue")
    private CamelContext produceUsersToUsersQueue;
    @Autowired
    @Qualifier("produceAirportsToAirportsQueue")
    private CamelContext produceAirportsToAirportsQueue;

    @Override
    public void produceCollectionOfCitiesToCitiesQueue() {
        String message = converterService.convertListToJsonString(
                cityService.findAll()
        );

        try {
            produceCitiesToCitiesQueue.start();

            ProducerTemplate producerTemplate = produceCitiesToCitiesQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:cities", message);

            produceCitiesToCitiesQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfAirportsToAirportsQueue() {
        String message = converterService.convertListToJsonString(
                airportService.findAll()
        );

        try {
            produceAirportsToAirportsQueue.start();

            ProducerTemplate producerTemplate = produceAirportsToAirportsQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:airports", message);

            produceAirportsToAirportsQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void produceCollectionOfUsersToUsersQueue() {
        String message = converterService.convertListToJsonString(
                userService.findAll()
        );

        try {
            produceUsersToUsersQueue.start();

            ProducerTemplate producerTemplate = produceUsersToUsersQueue.createProducerTemplate();
            producerTemplate.sendBody("direct:users", message);

            produceUsersToUsersQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
