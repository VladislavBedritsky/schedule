package org.kek.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 *
 * StationFlight DTO.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class StationFlight {

    @Id
    private String id;
    private String date;
    private String stationYandexCode;
    private String stationIataCode;
    private String stationTitle;
    private String popularTitle;
    /**
     * Days on which the thread does not run.
     */
    private String exceptDays;
    private String arrivalTime;
    private String threadTitle;
    private String threadNumber;
    private String carrierIataCode;
    private String carrierTitle;
    private String vehicle;
    /**
     * Days on which the thread will run.
     */
    private String days;
    /**
     * Stations of the flight following which stop is made.
     */
    private String stops;
    private String departureTime;
    private String terminal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStationYandexCode() {
        return stationYandexCode;
    }

    public void setStationYandexCode(String stationYandexCode) {
        this.stationYandexCode = stationYandexCode;
    }

    public String getStationIataCode() {
        return stationIataCode;
    }

    public void setStationIataCode(String stationIataCode) {
        this.stationIataCode = stationIataCode;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public void setStationTitle(String stationTitle) {
        this.stationTitle = stationTitle;
    }

    public String getPopularTitle() {
        return popularTitle;
    }

    public void setPopularTitle(String popularTitle) {
        this.popularTitle = popularTitle;
    }

    public String getExceptDays() {
        return exceptDays;
    }

    public void setExceptDays(String exceptDays) {
        this.exceptDays = exceptDays;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public String getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(String threadNumber) {
        this.threadNumber = threadNumber;
    }

    public String getCarrierIataCode() {
        return carrierIataCode;
    }

    public void setCarrierIataCode(String carrierIataCode) {
        this.carrierIataCode = carrierIataCode;
    }

    public String getCarrierTitle() {
        return carrierTitle;
    }

    public void setCarrierTitle(String carrierTitle) {
        this.carrierTitle = carrierTitle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationFlight that = (StationFlight) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(stationYandexCode, that.stationYandexCode) &&
                Objects.equals(stationIataCode, that.stationIataCode) &&
                Objects.equals(stationTitle, that.stationTitle) &&
                Objects.equals(popularTitle, that.popularTitle) &&
                Objects.equals(exceptDays, that.exceptDays) &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(threadTitle, that.threadTitle) &&
                Objects.equals(threadNumber, that.threadNumber) &&
                Objects.equals(carrierIataCode, that.carrierIataCode) &&
                Objects.equals(carrierTitle, that.carrierTitle) &&
                Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(days, that.days) &&
                Objects.equals(stops, that.stops) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(terminal, that.terminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, stationYandexCode, stationIataCode, stationTitle, popularTitle, exceptDays, arrivalTime, threadTitle, threadNumber, carrierIataCode, carrierTitle, vehicle, days, stops, departureTime, terminal);
    }

    @Override
    public String toString() {
        return "StationFlight{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", stationYandexCode='" + stationYandexCode + '\'' +
                ", stationIataCode='" + stationIataCode + '\'' +
                ", stationTitle='" + stationTitle + '\'' +
                ", popularTitle='" + popularTitle + '\'' +
                ", exceptDays='" + exceptDays + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadNumber='" + threadNumber + '\'' +
                ", carrierIataCode='" + carrierIataCode + '\'' +
                ", carrierTitle='" + carrierTitle + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", days='" + days + '\'' +
                ", stops='" + stops + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", terminal='" + terminal + '\'' +
                '}';
    }
}
