package org.kek.camel.dto;

import java.util.Objects;

/**
 *
 * City DTO for saving into MongoDb via camel routes
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public class CityDto {

    private String cityName;
    private String iataCode;
    private String countryCode;
    private String latitude;
    private String longitude;
    private String timezone;
    private String alternateNames;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(String alternateNames) {
        this.alternateNames = alternateNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(cityName, cityDto.cityName) &&
                Objects.equals(iataCode, cityDto.iataCode) &&
                Objects.equals(countryCode, cityDto.countryCode) &&
                Objects.equals(latitude, cityDto.latitude) &&
                Objects.equals(longitude, cityDto.longitude) &&
                Objects.equals(timezone, cityDto.timezone) &&
                Objects.equals(alternateNames, cityDto.alternateNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, iataCode, countryCode, latitude, longitude, timezone, alternateNames);
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "cityName='" + cityName + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timezone='" + timezone + '\'' +
                ", alternateNames='" + alternateNames + '\'' +
                '}';
    }
}
