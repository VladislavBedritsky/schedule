package org.kek.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.kek.backend.model.User;
import org.kek.data.model.rapidApi.CityResponse;
import org.kek.data.model.rapidApi.RapidApiResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

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

}