import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.data.model.aviasales.FlightData;
import org.kek.data.service.AviasalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:data-test.xml"})
public class ExampleTest {

    @Autowired
    private AviasalesService aviasalesService;

    @Test
    public void test() {
        Map<String, FlightData> map = aviasalesService.getMapOFCheapFlights("DUB", "LHR", "2020-07-25", "USD", "LON");
        aviasalesService.convertMapOfFlightDataToListOfFlights(map).forEach(System.out::println);
    }
}
