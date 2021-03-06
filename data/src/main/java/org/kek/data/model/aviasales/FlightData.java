package org.kek.data.model.aviasales;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * This class provides information about flight from aviasales API response
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public class FlightData {

    private Long price;
    private String airline;
    @JsonProperty("flight_number")
    private Long flightNumber;
    @JsonProperty("departure_at")
    private String departureTime;
    @JsonProperty("return_at")
    private String arrivalTime;
    @JsonProperty("expires_at")
    private String expiresTime;
    private String originIataCode;
    private String destinationIataCode;
    private String currency;
    private String carrierLogoUri;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(String expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getOriginIataCode() {
        return originIataCode;
    }

    public void setOriginIataCode(String originIataCode) {
        this.originIataCode = originIataCode;
    }

    public String getDestinationIataCode() {
        return destinationIataCode;
    }

    public void setDestinationIataCode(String destinationIataCode) {
        this.destinationIataCode = destinationIataCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCarrierLogoUri() {
        return carrierLogoUri;
    }

    public void setCarrierLogoUri(String carrierLogoUri) {
        this.carrierLogoUri = carrierLogoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightData that = (FlightData) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(airline, that.airline) &&
                Objects.equals(flightNumber, that.flightNumber) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(expiresTime, that.expiresTime) &&
                Objects.equals(originIataCode, that.originIataCode) &&
                Objects.equals(destinationIataCode, that.destinationIataCode) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(carrierLogoUri, that.carrierLogoUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, airline, flightNumber, departureTime, arrivalTime, expiresTime, originIataCode, destinationIataCode, currency, carrierLogoUri);
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "price=" + price +
                ", airline='" + airline + '\'' +
                ", flightNumber=" + flightNumber +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", expiresTime='" + expiresTime + '\'' +
                ", originIataCode='" + originIataCode + '\'' +
                ", destinationIataCode='" + destinationIataCode + '\'' +
                ", currency='" + currency + '\'' +
                ", carrierLogoUri='" + carrierLogoUri + '\'' +
                '}';
    }
}
