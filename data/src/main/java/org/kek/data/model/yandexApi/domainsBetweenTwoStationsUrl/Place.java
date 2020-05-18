package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import java.util.Objects;

/**
 *
 * Information about the available types of tickets and their price.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Place {

    private String currency;
    private Price price;
    private String name;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(currency, place.currency) &&
                Objects.equals(name, place.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, name);
    }

    @Override
    public String toString() {
        return "Place{" +
                "currency='" + currency + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
