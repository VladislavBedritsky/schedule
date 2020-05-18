package org.kek.data.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:data-test.xml"})
public class YandexApiServiceImplTest {

    @Autowired
    private YandexApiService yandexApiService;

    @Test
    public void getResponse() {

        System.out.println(yandexApiService.getFlightsBetweenTwoPointsByDate("SVO", "CDG", null));


    }
}