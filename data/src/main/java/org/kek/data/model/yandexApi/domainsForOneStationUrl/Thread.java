package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.TransportSubtype;

import java.util.Objects;

/**
 * Thread information.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Thread {

    /**
     * Thread ID accepted in Yandex Schedules.
     */
    private String uid;
    private String title;
    /**
     * Thread number.
     */
    private String number;
    @JsonProperty("short_title")
    private String shortTitle;
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
    private String express_type;

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

    public String getExpress_type() {
        return express_type;
    }

    public void setExpress_type(String express_type) {
        this.express_type = express_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thread thread = (Thread) o;
        return Objects.equals(uid, thread.uid) &&
                Objects.equals(title, thread.title) &&
                Objects.equals(number, thread.number) &&
                Objects.equals(shortTitle, thread.shortTitle) &&
                Objects.equals(carrier, thread.carrier) &&
                Objects.equals(transportType, thread.transportType) &&
                Objects.equals(vehicle, thread.vehicle) &&
                Objects.equals(transportSubtype, thread.transportSubtype) &&
                Objects.equals(express_type, thread.express_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, number, shortTitle, carrier, transportType, vehicle, transportSubtype, express_type);
    }

    @Override
    public String toString() {
        return "Thread{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", carrier=" + carrier +
                ", transportType='" + transportType + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", transportSubtype='" + transportSubtype + '\'' +
                ", express_type='" + express_type + '\'' +
                '}';
    }
}
