package org.kek.data.model.aviationstackApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AirportData {

    @JsonProperty("airport_name")
    private String airportName;
    @JsonProperty("iata_code")
    private String iataCode;
    @JsonProperty("icao_code")
    private String icaoCode;
    private String latitude;
    private String longitude;
    @JsonProperty("geoname_id")
    private String geoNameId;
    private String timezone;
    private String gmt;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("country_iso2")
    private String countryIso2;
    @JsonProperty("city_iata_code")
    private String cityIataCode;

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

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        AirportData that = (AirportData) o;
        return Objects.equals(airportName, that.airportName) &&
                Objects.equals(iataCode, that.iataCode) &&
                Objects.equals(icaoCode, that.icaoCode) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(geoNameId, that.geoNameId) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(gmt, that.gmt) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(countryIso2, that.countryIso2) &&
                Objects.equals(cityIataCode, that.cityIataCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName, iataCode, icaoCode, latitude, longitude, geoNameId, timezone, gmt, phoneNumber, countryName, countryIso2, cityIataCode);
    }

    @Override
    public String toString() {
        return "AirportData{" +
                "airportName='" + airportName + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", geoNameId='" + geoNameId + '\'' +
                ", timezone='" + timezone + '\'' +
                ", gmt='" + gmt + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryIso2='" + countryIso2 + '\'' +
                ", cityIataCode='" + cityIataCode + '\'' +
                '}';
    }
}
