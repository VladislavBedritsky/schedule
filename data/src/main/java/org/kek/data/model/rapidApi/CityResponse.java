package org.kek.data.model.rapidApi;

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
public class CityResponse {

    private String code;
    @JsonProperty("country_code")
    private String countryCode;
    private String name;
    @JsonProperty("alternatenames")
    private String alternateNames;
    private Double lat;
    private Double lng;
    private String timezone;
    private Integer gmt;
    @JsonProperty("tch_code")
    private String tchCode;
    private Long popularity;
    @JsonProperty("geoname_id")
    private Long geonameId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(String alternateNames) {
        this.alternateNames = alternateNames;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getGmt() {
        return gmt;
    }

    public void setGmt(Integer gmt) {
        this.gmt = gmt;
    }

    public String getTchCode() {
        return tchCode;
    }

    public void setTchCode(String tchCode) {
        this.tchCode = tchCode;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    public Long getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Long geonameId) {
        this.geonameId = geonameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityResponse that = (CityResponse) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(name, that.name) &&
                Objects.equals(alternateNames, that.alternateNames) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(gmt, that.gmt) &&
                Objects.equals(tchCode, that.tchCode) &&
                Objects.equals(popularity, that.popularity) &&
                Objects.equals(geonameId, that.geonameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, countryCode, name, alternateNames, lat, lng, timezone, gmt, tchCode, popularity, geonameId);
    }

    @Override
    public String toString() {
        return "CityResponse{" +
                "code='" + code + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                ", alternateNames='" + alternateNames + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", timezone='" + timezone + '\'' +
                ", gmt=" + gmt +
                ", tchCode='" + tchCode + '\'' +
                ", popularity=" + popularity +
                ", geonameId=" + geonameId +
                '}';
    }
}
