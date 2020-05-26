package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 *
 * Information about the schedule.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Schedule {

    /**
     * Days on which the thread does not run.
     */
    @JsonProperty("except_days")
    private String exceptDays;
    @JsonProperty("arrival")
    private String arrivalTime;
    private Thread thread;
    /**
     * Sign of inaccuracy of departure time and arrival time.
     */
    @JsonProperty("is_fuzzy")
    private Boolean isFuzzy;
    /**
     * Days on which the thread will run.
     */
    private String days;
    /**
     * Stations of the flight following which stop is made.
     */
    private String stops;
    @JsonProperty("departure")
    private String departureTime;
    private String terminal;
    private String platform;

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

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Boolean getFuzzy() {
        return isFuzzy;
    }

    public void setFuzzy(Boolean fuzzy) {
        isFuzzy = fuzzy;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(exceptDays, schedule.exceptDays) &&
                Objects.equals(arrivalTime, schedule.arrivalTime) &&
                Objects.equals(thread, schedule.thread) &&
                Objects.equals(isFuzzy, schedule.isFuzzy) &&
                Objects.equals(days, schedule.days) &&
                Objects.equals(stops, schedule.stops) &&
                Objects.equals(departureTime, schedule.departureTime) &&
                Objects.equals(terminal, schedule.terminal) &&
                Objects.equals(platform, schedule.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exceptDays, arrivalTime, thread, isFuzzy, days, stops, departureTime, terminal, platform);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "exceptDays='" + exceptDays + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", thread=" + thread +
                ", isFuzzy=" + isFuzzy +
                ", days='" + days + '\'' +
                ", stops='" + stops + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", terminal='" + terminal + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
