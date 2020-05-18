package org.kek.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Ticket {

    @Id
    private String id;
    /**
     * Sign of an opportunity to buy an electronic ticket.
     */
    private Boolean etMarker;
    private String name;
    private String currency;
    private Integer cents;
    private Long whole;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getEtMarker() {
        return etMarker;
    }

    public void setEtMarker(Boolean etMarker) {
        this.etMarker = etMarker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCents() {
        return cents;
    }

    public void setCents(Integer cents) {
        this.cents = cents;
    }

    public Long getWhole() {
        return whole;
    }

    public void setWhole(Long whole) {
        this.whole = whole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(etMarker, ticket.etMarker) &&
                Objects.equals(name, ticket.name) &&
                Objects.equals(currency, ticket.currency) &&
                Objects.equals(cents, ticket.cents) &&
                Objects.equals(whole, ticket.whole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, etMarker, name, currency, cents, whole);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", etMarker=" + etMarker +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", cents=" + cents +
                ", whole=" + whole +
                '}';
    }
}
