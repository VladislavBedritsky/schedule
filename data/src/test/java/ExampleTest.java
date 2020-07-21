import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.data.model.aviasales.CheapFlightsResponse;
import org.kek.data.model.aviasales.FlightData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:data-test.xml"})
public class ExampleTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() throws IOException {

        String betweenTwoPointsByDateUri =
                "http://api.travelpayouts.com/v1/prices/cheap?token=be94f12493eab45cb8b5fb2f3471dff7" +
                        "&origin={0}&destination={1}&depart_date={2}";

        String string = MessageFormat.format(
                betweenTwoPointsByDateUri,
                "MOW", "LHR", "2020-07-25");

        String jsonFromRestUrl = getJsonFromRestUrl(string);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonFromRestUrl);

        String currency = jsonNode.get("currency").asText();

        String data = jsonNode.get("data").toString();
        jsonNode = objectMapper.readTree(data);

        String lon = "LON";
        String city = jsonNode.get(lon).toString();

        jsonNode = objectMapper.readTree(city);

        Map<String, FlightData> result =
                objectMapper
                        .convertValue(jsonNode, new TypeReference<HashMap<String, FlightData> >(){});

        for (int i = 0;; i++) {
            try {
                System.out.println(result.get(Integer.toString(i)).getPrice());
            } catch (NullPointerException e) {
                break;
            }
        }
    }

    public String getJsonFromRestUrl(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()
                )
        );

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();

        return response.toString();
    }
}
