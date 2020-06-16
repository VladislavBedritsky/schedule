package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.backend.model.User;
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

    @Override
    public List<User> getUsersFromScheduleQueue() {
        List<User> users = new ArrayList<>();
        try {
            consumeDataFromScheduleQueue.start();
            System.out.println("qq");

            ConsumerTemplate consumerTemplate = consumeDataFromScheduleQueue.createConsumerTemplate();
            users = consumerTemplate.receiveBody("seda:end", List.class);

            System.out.println("qs");
            consumeDataFromScheduleQueue.stop();
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return users;
    }

}
