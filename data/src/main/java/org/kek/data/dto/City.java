package org.kek.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class City {

    @Id
    private String id;
    private String cityName;
    private String iataCode;
    private String countryCode;
    private String latitude;
    private String longitude;
    private String timezone;
    private String alternateNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(iataCode, city.iataCode) &&
                Objects.equals(latitude, city.latitude) &&
                Objects.equals(longitude, city.longitude) &&
                Objects.equals(timezone, city.timezone) &&
                Objects.equals(countryCode, city.countryCode) &&
                Objects.equals(alternateNames, city.alternateNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, iataCode, latitude, longitude, timezone, countryCode, alternateNames);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timezone='" + timezone + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", alternateNames='" + alternateNames + '\'' +
                '}';
    }
}
