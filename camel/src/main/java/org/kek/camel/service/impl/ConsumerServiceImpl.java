package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kek.camel.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CamelContext consumeUsersFromScheduleQueue;

    @Override
    public void consumeDataFromScheduleQueue() {
        try {
            consumeUsersFromScheduleQueue.start();
            Thread.sleep(1000);
            consumeUsersFromScheduleQueue.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
