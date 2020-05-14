package org.kek.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Airport {

    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) &&
                Objects.equals(airportName, airport.airportName) &&
                Objects.equals(iataCode, airport.iataCode) &&
                Objects.equals(icaoCode, airport.icaoCode) &&
                Objects.equals(latitude, airport.latitude) &&
                Objects.equals(longitude, airport.longitude) &&
                Objects.equals(geoNameId, airport.geoNameId) &&
                Objects.equals(timezone, airport.timezone) &&
                Objects.equals(countryName, airport.countryName) &&
                Objects.equals(countryIso2, airport.countryIso2) &&
                Objects.equals(cityIataCode, airport.cityIataCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportName, iataCode, icaoCode, latitude, longitude, geoNameId, timezone, countryName, countryIso2, cityIataCode);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", airportName='" + airportName + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", geoNameId='" + geoNameId + '\'' +
                ", timezone='" + timezone + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryIso2='" + countryIso2 + '\'' +
                ", cityIataCode='" + cityIataCode + '\'' +
                '}';
    }
}
