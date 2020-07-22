package org.kek.data.service.impl;

import org.kek.data.service.UrlService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 *
 * UrlService implementation.
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Override
    public String getJsonInTypeStringFromRestUrl(String url) {
        StringBuilder result = new StringBuilder();
        try {
            URL urlObject  = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            BufferedReader bufferedReader  = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()
                    )
            );

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                result.append(inputLine);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Objects.requireNonNull(result).toString();
    }
}
