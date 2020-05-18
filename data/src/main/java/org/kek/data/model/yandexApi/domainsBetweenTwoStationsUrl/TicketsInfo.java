package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 *
 * Information about the available types of tickets and their price.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class TicketsInfo {

    /**
     * Sign of an opportunity to buy an electronic ticket.
     */
    @JsonProperty("et_marker")
    private Boolean etMarker;
    private List<Place> places;

    public Boolean getEtMarker() {
        return etMarker;
    }

    public void setEtMarker(Boolean etMarker) {
        this.etMarker = etMarker;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsInfo that = (TicketsInfo) o;
        return Objects.equals(etMarker, that.etMarker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etMarker);
    }

    @Override
    public String toString() {
        return "TicketsInfo{" +
                "etMarker=" + etMarker +
                ", places=" + places +
                '}';
    }
}
