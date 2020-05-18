package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import java.util.Objects;

/**
 *
 * Information about price.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Price {

    private Integer cents;
    /**
     * Integer of basic currency units.
     */
    private Long whole;

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
        Price price = (Price) o;
        return Objects.equals(cents, price.cents) &&
                Objects.equals(whole, price.whole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents, whole);
    }

    @Override
    public String toString() {
        return "Price{" +
                "cents=" + cents +
                ", whole=" + whole +
                '}';
    }
}
