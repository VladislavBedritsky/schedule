package org.kek.backend.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.RouteDao;
import org.kek.backend.service.RouteService;
import org.kek.data.model.aviasales.Route;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class RouteServiceImplTest {

    @InjectMocks
    private RouteService routeService;
    @Mock
    private RouteDao routeDao;

    @Before
    public void setUp() throws Exception {
        routeService = new RouteServiceImpl();
    }

    @Test
    public void saveRoute() {
        routeService.saveRoute(new Route());
        Mockito.verify(routeDao, Mockito.times(1))
                .saveRoute(isA(Route.class));
    }

    @Test
    public void findAll() {
        routeService.findAll();
        Mockito.verify(routeDao, Mockito.times(1))
                .findAll();
    }
}