package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 *
 * Information about the station.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Station {

    private String code;
    @JsonProperty("station_type")
    private String stationType;
    @JsonProperty("station_type_name")
    private String stationTypeName;
    private String title;
    @JsonProperty("popular_title")
    private String popularTitle;
    @JsonProperty("short_title")
    private String shortTitle;
    @JsonProperty("transport_type")
    private String transportType;
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getStationTypeName() {
        return stationTypeName;
    }

    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularTitle() {
        return popularTitle;
    }

    public void setPopularTitle(String popularTitle) {
        this.popularTitle = popularTitle;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(code, station.code) &&
                Objects.equals(stationType, station.stationType) &&
                Objects.equals(stationTypeName, station.stationTypeName) &&
                Objects.equals(title, station.title) &&
                Objects.equals(popularTitle, station.popularTitle) &&
                Objects.equals(shortTitle, station.shortTitle) &&
                Objects.equals(transportType, station.transportType) &&
                Objects.equals(type, station.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, stationType, stationTypeName, title, popularTitle, shortTitle, transportType, type);
    }

    @Override
    public String toString() {
        return "Station{" +
                "code='" + code + '\'' +
                ", stationType='" + stationType + '\'' +
                ", stationTypeName='" + stationTypeName + '\'' +
                ", title='" + title + '\'' +
                ", popularTitle='" + popularTitle + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", transportType='" + transportType + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
