package org.kek.camel.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.camel.service.ConsumerService;
import org.kek.camel.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:camel-test.xml"})
public class ConsumerServiceImplTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private ConsumerService consumerService;

    @Test
    public void foo() {
        producerService.produceCollectionOfUsersToScheduleQueue();
        consumerService.getUsersFromScheduleQueue();
    }
}