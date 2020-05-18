package org.kek.data.model.yandexApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Information about the flight arrival station.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class SegmentsTo {

    /**
     * The code of the point of departure in the Yandex schedules encoding system.
     */
    private String code;
    private String title;
    @JsonProperty("station_type")
    private String stationType;
    @JsonProperty("station_type_name")
    private String stationTypeName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        SegmentsTo that = (SegmentsTo) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(title, that.title) &&
                Objects.equals(stationType, that.stationType) &&
                Objects.equals(stationTypeName, that.stationTypeName) &&
                Objects.equals(popularTitle, that.popularTitle) &&
                Objects.equals(shortTitle, that.shortTitle) &&
                Objects.equals(transportType, that.transportType) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, stationType, stationTypeName, popularTitle, shortTitle, transportType, type);
    }

    @Override
    public String toString() {
        return "SegmentsTo{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", stationType='" + stationType + '\'' +
                ", stationTypeName='" + stationTypeName + '\'' +
                ", popularTitle='" + popularTitle + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", transportType='" + transportType + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
