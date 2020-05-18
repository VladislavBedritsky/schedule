package org.kek.data.dto;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

/**
 *
 * Ticket DTO.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Flight {

    @Id
    private String id;
    private String timeArrival;
    private String fromIataCode;
    private String fromTitle;
    private String threadTitle;
    private String threadNumber;
    /**
     * URL for requesting thread information with the identifier specified in the uid key.
     */
    private String threadMethodLink;
    private String carrierUrl;
    /**
     * Link to the carrier’s logo used by Yandex in SVG format.
     */
    private String carrierLogoSvg;
    private String carrierTitle;
    private String carrierEmail;
    private String vehicleName;
    private String departureTime;
    private String departureTerminal;
    private String toIataCode;
    private String toTitle;
    private Long duration;
    private String arrivalTerminal;
    private String startDate;
    private String requestDate;
    private List<Ticket> tickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public String getFromIataCode() {
        return fromIataCode;
    }

    public void setFromIataCode(String fromIataCode) {
        this.fromIataCode = fromIataCode;
    }

    public String getFromTitle() {
        return fromTitle;
    }

    public void setFromTitle(String fromTitle) {
        this.fromTitle = fromTitle;
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

    public String getThreadMethodLink() {
        return threadMethodLink;
    }

    public void setThreadMethodLink(String threadMethodLink) {
        this.threadMethodLink = threadMethodLink;
    }

    public String getCarrierUrl() {
        return carrierUrl;
    }

    public void setCarrierUrl(String carrierUrl) {
        this.carrierUrl = carrierUrl;
    }

    public String getCarrierLogoSvg() {
        return carrierLogoSvg;
    }

    public void setCarrierLogoSvg(String carrierLogoSvg) {
        this.carrierLogoSvg = carrierLogoSvg;
    }

    public String getCarrierTitle() {
        return carrierTitle;
    }

    public void setCarrierTitle(String carrierTitle) {
        this.carrierTitle = carrierTitle;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getToIataCode() {
        return toIataCode;
    }

    public void setToIataCode(String toIataCode) {
        this.toIataCode = toIataCode;
    }

    public String getToTitle() {
        return toTitle;
    }

    public void setToTitle(String toTitle) {
        this.toTitle = toTitle;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) &&
                Objects.equals(timeArrival, flight.timeArrival) &&
                Objects.equals(fromIataCode, flight.fromIataCode) &&
                Objects.equals(fromTitle, flight.fromTitle) &&
                Objects.equals(threadTitle, flight.threadTitle) &&
                Objects.equals(threadNumber, flight.threadNumber) &&
                Objects.equals(threadMethodLink, flight.threadMethodLink) &&
                Objects.equals(carrierUrl, flight.carrierUrl) &&
                Objects.equals(carrierLogoSvg, flight.carrierLogoSvg) &&
                Objects.equals(carrierTitle, flight.carrierTitle) &&
                Objects.equals(carrierEmail, flight.carrierEmail) &&
                Objects.equals(vehicleName, flight.vehicleName) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(departureTerminal, flight.departureTerminal) &&
                Objects.equals(toIataCode, flight.toIataCode) &&
                Objects.equals(toTitle, flight.toTitle) &&
                Objects.equals(duration, flight.duration) &&
                Objects.equals(arrivalTerminal, flight.arrivalTerminal) &&
                Objects.equals(startDate, flight.startDate) &&
                Objects.equals(requestDate, flight.requestDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeArrival, fromIataCode, fromTitle, threadTitle, threadNumber, threadMethodLink, carrierUrl, carrierLogoSvg, carrierTitle, carrierEmail, vehicleName, departureTime, departureTerminal, toIataCode, toTitle, duration, arrivalTerminal, startDate, requestDate);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", timeArrival='" + timeArrival + '\'' +
                ", fromIataCode='" + fromIataCode + '\'' +
                ", fromTitle='" + fromTitle + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadNumber='" + threadNumber + '\'' +
                ", threadMethodLink='" + threadMethodLink + '\'' +
                ", carrierUrl='" + carrierUrl + '\'' +
                ", carrierLogoSvg='" + carrierLogoSvg + '\'' +
                ", carrierTitle='" + carrierTitle + '\'' +
                ", carrierEmail='" + carrierEmail + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", departureTerminal='" + departureTerminal + '\'' +
                ", toIataCode='" + toIataCode + '\'' +
                ", toTitle='" + toTitle + '\'' +
                ", duration=" + duration +
                ", arrivalTerminal='" + arrivalTerminal + '\'' +
                ", startDate='" + startDate + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
