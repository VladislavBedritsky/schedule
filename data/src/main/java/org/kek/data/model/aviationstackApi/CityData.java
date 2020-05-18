package org.kek.data.model.aviationstackApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 *
 * City information.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class CityData {

    private String gmt;
    @JsonProperty("iata_code")
    private String iataCode;
    @JsonProperty("country_iso2")
    private String countryIso2;
    @JsonProperty("geoname_id")
    private String geoNameId;
    private String latitude;
    private String longitude;
    @JsonProperty("city_name")
    private String cityName;
    private String timezone;

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(String geoNameId) {
        this.geoNameId = geoNameId;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityData cityData = (CityData) o;
        return Objects.equals(gmt, cityData.gmt) &&
                Objects.equals(iataCode, cityData.iataCode) &&
                Objects.equals(countryIso2, cityData.countryIso2) &&
                Objects.equals(geoNameId, cityData.geoNameId) &&
                Objects.equals(latitude, cityData.latitude) &&
                Objects.equals(longitude, cityData.longitude) &&
                Objects.equals(cityName, cityData.cityName) &&
                Objects.equals(timezone, cityData.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gmt, iataCode, countryIso2, geoNameId, latitude, longitude, cityName, timezone);
    }

    @Override
    public String toString() {
        return "CityData{" +
                "gmt='" + gmt + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", countryIso2l='" + countryIso2 + '\'' +
                ", geoNameId='" + geoNameId + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", cityName='" + cityName + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
