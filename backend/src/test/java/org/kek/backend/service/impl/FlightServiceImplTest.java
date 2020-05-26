package org.kek.backend.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.service.FlightService;
import org.kek.data.service.YandexApiService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class FlightServiceImplTest {

    @InjectMocks
    private FlightService flightService;
    @Mock
    private YandexApiService yandexApiService;

    public FlightServiceImplTest() {
        flightService = new FlightServiceImpl();
    }

    @Test
    public void getFlightsBetweenTwoPointsByDate() {
        flightService.getFlightsBetweenTwoPointsByDate("from","to","date");
        Mockito.verify(yandexApiService, Mockito.times(1))
                .getFlightsBetweenTwoPointsByDate(
                        isA(String.class), isA(String.class), isA(String.class)
                );
    }
}