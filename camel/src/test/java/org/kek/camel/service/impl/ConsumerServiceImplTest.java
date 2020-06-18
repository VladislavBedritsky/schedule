package org.kek.camel.service.impl;

import org.apache.camel.CamelContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.camel.service.ConsumerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:camel-test.xml"})
public class ConsumerServiceImplTest {

    @InjectMocks
    private ConsumerService consumerService = new ConsumerServiceImpl();
    @Mock
    private CamelContext consumeUsers;
    @Mock
    private CamelContext consumeCities;
    @Mock
    private CamelContext consumeAirports;

    @Before
    public void setUp() {
    }

    @Test
    public void consumeUsersFromUsersQueueTest() throws Exception {
        consumerService.consumeUsersFromUsersQueue();

        Mockito.verify(consumeUsers, Mockito.times(1))
                .start();
        Mockito.verify(consumeUsers, Mockito.times(1))
                .stop();
    }

    @Test
    public void consumeCitiesFromCitiesQueueTest() throws Exception {
        consumerService.consumeCitiesFromCitiesQueue();

        Mockito.verify(consumeCities, Mockito.times(1))
                .start();
        Mockito.verify(consumeCities, Mockito.times(1))
                .stop();
    }

    @Test
    public void consumeAirportsFromAirportsQueueTest() throws Exception {
        consumerService.consumeAirportsFromAirportsQueue();

        Mockito.verify(consumeAirports, Mockito.times(1))
                .start();
        Mockito.verify(consumeAirports, Mockito.times(1))
                .stop();
    }


}