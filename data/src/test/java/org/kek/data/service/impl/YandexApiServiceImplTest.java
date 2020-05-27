package org.kek.data.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.data.service.YandexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:data-test.xml"})
public class YandexApiServiceImplTest {

    @Autowired
    private YandexApiService yandexApiService;

    @Test
    public void getResponse() {
        System.out.println(yandexApiService.getFlightsByStationIataCodeAndDateAndEvent(
                "VKO", "2020-05-27", "arrival"));
    }
}