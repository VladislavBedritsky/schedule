package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.backend.model.User;
import org.kek.backend.service.ConverterService;
import org.kek.camel.service.ConsumerService;
import org.kek.data.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private CamelContext consumeDataFromScheduleQueue;
    @Autowired
    private ConverterService converterService;

    @Override
    public List<User> getUsersFromScheduleQueue() {
        List<User> users = new ArrayList<>();
        try {
            consumeDataFromScheduleQueue.start();

            ConsumerTemplate consumerTemplate = consumeDataFromScheduleQueue.createConsumerTemplate();
            String result = consumerTemplate.receiveBody("seda:end", String.class);

            users = converterService.convertJsonToListOfUsers(result);

            consumeDataFromScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return users;
    }

}
