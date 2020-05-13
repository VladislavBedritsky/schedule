package org.kek.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.kek.backend.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class MainControllerTest {

    @Test
    public void q() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/users";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl + "/5eba7a87f911b0b8abbd7f0b", String.class);
        System.out.println(response.getBody());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("username");
        System.out.println(name);

        User user = restTemplate.getForObject(resourceUrl + "/5eba7a87f911b0b8abbd7f0b", User.class);
        System.out.println(user.getUsername());

        ResponseEntity<User[]> response1 = restTemplate.getForEntity(resourceUrl, User[].class);
        User[] users = response1.getBody();

        System.out.println(Arrays.toString(users));


    }

    @Test
    public void q1() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://iatacodes-iatacodes-v1.p.rapidapi.com/api/v5/cities?code=PAR&lang=en&api_key=YOUR-API-KEY";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "iatacodes-iatacodes-v1.p.rapidapi.com");
        headers.set("x-rapidapi-key", "72f55d99c1msh1ac6e1d56db31dep16e613jsn3106384d6054");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        System.out.println(root.path("response").toPrettyString());
    }

}