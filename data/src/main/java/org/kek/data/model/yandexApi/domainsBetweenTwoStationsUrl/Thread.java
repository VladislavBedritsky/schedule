package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.TransportSubtype;

import java.util.Objects;

/**
 * Thread information.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Thread {

    /**
     * Thread ID accepted in Yandex Schedules.
     */
    private String uid;
    private String title;
    private Interval interval;
    /**
     * Flight number.
     */
    private String number;
    @JsonProperty("short_title")
    private String shortTitle;
    /**
     * URL for requesting thread information with the identifier specified in the uid key.
     */
    @JsonProperty("thread_method_link")
    private String threadMethodLink;
    private Carrier carrier;
    @JsonProperty("transport_type")
    private String transportType;
    /**
     * The name of the vehicle.
     */
    private String vehicle;
    @JsonProperty("transport_subtype")
    private TransportSubtype transportSubtype;
    /**
     * Sign of express or aeroexpress.
     */
    @JsonProperty("express_type")
    private String expressType;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getThreadMethodLink() {
        return threadMethodLink;
    }

    public void setThreadMethodLink(String threadMethodLink) {
        this.threadMethodLink = threadMethodLink;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public TransportSubtype getTransportSubtype() {
        return transportSubtype;
    }

    public void setTransportSubtype(TransportSubtype transportSubtype) {
        this.transportSubtype = transportSubtype;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thread thread = (Thread) o;
        return Objects.equals(uid, thread.uid) &&
                Objects.equals(title, thread.title) &&
                Objects.equals(interval, thread.interval) &&
                Objects.equals(number, thread.number) &&
                Objects.equals(shortTitle, thread.shortTitle) &&
                Objects.equals(threadMethodLink, thread.threadMethodLink) &&
                Objects.equals(transportType, thread.transportType) &&
                Objects.equals(vehicle, thread.vehicle) &&
                Objects.equals(expressType, thread.expressType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, interval, number, shortTitle, threadMethodLink, transportType, vehicle, expressType);
    }

    @Override
    public String toString() {
        return "Thread{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", interval=" + interval +
                ", number='" + number + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", threadMethodLink='" + threadMethodLink + '\'' +
                ", carrier=" + carrier +
                ", transportType='" + transportType + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", transportSubtype=" + transportSubtype +
                ", express_type='" + expressType + '\'' +
                '}';
    }
}
