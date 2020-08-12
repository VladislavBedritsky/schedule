import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.camel.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:camel-test.xml"})
public class ExampleTest {

    @Autowired
    private ConsumerService consumerService;

    @Test
    public void test() {
    }


}
