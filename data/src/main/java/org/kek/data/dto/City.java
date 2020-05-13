package org.kek.data.dto;

import org.springframework.data.annotation.Id;

public class City {

    @Id
    private String id;
    private String cityName;
    private String iataCode;
    private String latitude;
    private String longitude;
    private String timezone;

}
