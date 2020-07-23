package org.kek.data.model.aviasales;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * This class provides information about routes from aviasales API
 *
 * @version 1.01 23 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Route {

    @JsonProperty("airline_iata")
    private String airlineIata;
    @JsonProperty("airline_icao")
    private String airlineIcao;
    @JsonProperty("departure_airport_iata")
    private String departureAirportIata;
    @JsonProperty("departure_airport_icao")
    private String departureAirportIcao;
    @JsonProperty("arrival_airport_iata")
    private String arrivalAirportIata;
    @JsonProperty("arrival_airport_icao")
    private String arrivalAirportIcao;
    /**
     * Indicates whether the flight is operated by the same company that sells the ticket.
     */
    private Boolean codeshare;
    private Integer transfers;
    /**
     * Plane iata codes
     */
    private List<String> planes;

    public String getAirlineIata() {
        return airlineIata;
    }

    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    public String getAirlineIcao() {
        return airlineIcao;
    }

    public void setAirlineIcao(String airlineIcao) {
        this.airlineIcao = airlineIcao;
    }

    public String getDepartureAirportIata() {
        return departureAirportIata;
    }

    public void setDepartureAirportIata(String departureAirportIata) {
        this.departureAirportIata = departureAirportIata;
    }

    public String getDepartureAirportIcao() {
        return departureAirportIcao;
    }

    public void setDepartureAirportIcao(String departureAirportIcao) {
        this.departureAirportIcao = departureAirportIcao;
    }

    public String getArrivalAirportIata() {
        return arrivalAirportIata;
    }

    public void setArrivalAirportIata(String arrivalAirportIata) {
        this.arrivalAirportIata = arrivalAirportIata;
    }

    public String getArrivalAirportIcao() {
        return arrivalAirportIcao;
    }

    public void setArrivalAirportIcao(String arrivalAirportIcao) {
        this.arrivalAirportIcao = arrivalAirportIcao;
    }

    public Boolean getCodeshare() {
        return codeshare;
    }

    public void setCodeshare(Boolean codeshare) {
        this.codeshare = codeshare;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public List<String> getPlanes() {
        return planes;
    }

    public void setPlanes(List<String> planes) {
        this.planes = planes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(airlineIata, route.airlineIata) &&
                Objects.equals(airlineIcao, route.airlineIcao) &&
                Objects.equals(departureAirportIata, route.departureAirportIata) &&
                Objects.equals(departureAirportIcao, route.departureAirportIcao) &&
                Objects.equals(arrivalAirportIata, route.arrivalAirportIata) &&
                Objects.equals(arrivalAirportIcao, route.arrivalAirportIcao) &&
                Objects.equals(codeshare, route.codeshare) &&
                Objects.equals(transfers, route.transfers) &&
                Objects.equals(planes, route.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineIata, airlineIcao, departureAirportIata, departureAirportIcao, arrivalAirportIata, arrivalAirportIcao, codeshare, transfers, planes);
    }

    @Override
    public String toString() {
        return "Route{" +
                "airlineIata='" + airlineIata + '\'' +
                ", airlineIcao='" + airlineIcao + '\'' +
                ", departureAirportIata='" + departureAirportIata + '\'' +
                ", departureAirportIcao='" + departureAirportIcao + '\'' +
                ", arrivalAirportIata='" + arrivalAirportIata + '\'' +
                ", arrivalAirportIcao='" + arrivalAirportIcao + '\'' +
                ", codeshare=" + codeshare +
                ", transfers=" + transfers +
                ", planes=" + planes +
                '}';
    }
}
