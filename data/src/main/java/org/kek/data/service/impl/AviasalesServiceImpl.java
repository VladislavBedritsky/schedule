package org.kek.data.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

@Service
@PropertySource("classpath:url.properties")
public class AviasalesServiceImpl {

    @Value("${url.api.travelpayouts.findFlightsWithCheapPrices}")
    private String findCheapFlightsUrl;


    public void getCheapFlightsBetweenTwoPointsAndDate(String origin, String destination, String date) {
        String json = MessageFormat.format(
                findCheapFlightsUrl,
                origin,
                destination,
                date);

        String jsonFromRestUrl;
        try {
            jsonFromRestUrl = getJsonInTypeStringFromRestUrl(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getJsonInTypeStringFromRestUrl(String url) throws IOException {
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
