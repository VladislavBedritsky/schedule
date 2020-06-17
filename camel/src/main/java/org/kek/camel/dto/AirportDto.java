package org.kek.camel.dto;

import java.util.Objects;

/**
 *
 * Airport DTO for saving into MongoDb via camel routes
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public class AirportDto {

    private String airportName;
    private String iataCode;
    private String icaoCode;
    private String latitude;
    private String longitude;
    private String geoNameId;
    private String timezone;
    private String countryName;
    private String countryIso2;
    private String cityIataCode;
    private String cityName;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
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

    public String getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(String geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getCityIataCode() {
        return cityIataCode;
    }

    public void setCityIataCode(String cityIataCode) {
        this.cityIataCode = cityIataCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDto that = (AirportDto) o;
        return Objects.equals(airportName, that.airportName) &&
                Objects.equals(iataCode, that.iataCode) &&
                Objects.equals(icaoCode, that.icaoCode) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(geoNameId, that.geoNameId) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(countryIso2, that.countryIso2) &&
                Objects.equals(cityIataCode, that.cityIataCode) &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName, iataCode, icaoCode, latitude, longitude, geoNameId, timezone, countryName, countryIso2, cityIataCode, cityName);
    }

    @Override
    public String toString() {
        return "AirportDto{" +
                "airportName='" + airportName + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", geoNameId='" + geoNameId + '\'' +
                ", timezone='" + timezone + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryIso2='" + countryIso2 + '\'' +
                ", cityIataCode='" + cityIataCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
