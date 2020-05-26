package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Interval thread information.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Interval {

    private String density;
    private String endTime;
    @JsonProperty("begin_time")
    private String beginTime;

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Objects.equals(density, interval.density) &&
                Objects.equals(endTime, interval.endTime) &&
                Objects.equals(beginTime, interval.beginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(density, endTime, beginTime);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "density='" + density + '\'' +
                ", endTime='" + endTime + '\'' +
                ", beginTime='" + beginTime + '\'' +
                '}';
    }
}
