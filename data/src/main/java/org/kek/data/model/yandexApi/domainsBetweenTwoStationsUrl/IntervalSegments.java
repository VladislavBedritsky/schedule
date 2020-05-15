package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.SegmentsFrom;
import org.kek.data.model.yandexApi.SegmentsTo;
import org.kek.data.model.yandexApi.Thread;

import java.util.Objects;

public class IntervalSegments {

    private SegmentsFrom from;
    private Thread thread;
    @JsonProperty("departure_platform")
    private String departurePlatform;
    private String stops;
    @JsonProperty("departure_terminal")
    private String departureTerminal;
    private SegmentsTo to;
    @JsonProperty("has_transfers")
    private Boolean hasTransfers;
    @JsonProperty("tickets_info")
    private TicketsInfo ticketsInfo;
    private Long duration;
    @JsonProperty("arrival_terminal")
    private String arrivalTerminal;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("arrival_platform")
    private String arrivalPlatform;

    public SegmentsFrom getFrom() {
        return from;
    }

    public void setFrom(SegmentsFrom from) {
        this.from = from;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getDeparturePlatform() {
        return departurePlatform;
    }

    public void setDeparturePlatform(String departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public SegmentsTo getTo() {
        return to;
    }

    public void setTo(SegmentsTo to) {
        this.to = to;
    }

    public Boolean getHasTransfers() {
        return hasTransfers;
    }

    public void setHasTransfers(Boolean hasTransfers) {
        this.hasTransfers = hasTransfers;
    }

    public TicketsInfo getTicketsInfo() {
        return ticketsInfo;
    }

    public void setTicketsInfo(TicketsInfo ticketsInfo) {
        this.ticketsInfo = ticketsInfo;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getArrivalPlatform() {
        return arrivalPlatform;
    }

    public void setArrivalPlatform(String arrivalPlatform) {
        this.arrivalPlatform = arrivalPlatform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalSegments that = (IntervalSegments) o;
        return Objects.equals(departurePlatform, that.departurePlatform) &&
                Objects.equals(stops, that.stops) &&
                Objects.equals(departureTerminal, that.departureTerminal) &&
                Objects.equals(hasTransfers, that.hasTransfers) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(arrivalTerminal, that.arrivalTerminal) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(arrivalPlatform, that.arrivalPlatform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departurePlatform, stops, departureTerminal, hasTransfers, duration, arrivalTerminal, startDate, arrivalPlatform);
    }

    @Override
    public String toString() {
        return "IntervalSegments{" +
                "from=" + from +
                ", thread=" + thread +
                ", departurePlatform='" + departurePlatform + '\'' +
                ", stops='" + stops + '\'' +
                ", departureTerminal='" + departureTerminal + '\'' +
                ", to=" + to +
                ", hasTransfers=" + hasTransfers +
                ", ticketsInfo=" + ticketsInfo +
                ", duration=" + duration +
                ", arrivalTerminal='" + arrivalTerminal + '\'' +
                ", startDate='" + startDate + '\'' +
                ", arrivalPlatform='" + arrivalPlatform + '\'' +
                '}';
    }
}
