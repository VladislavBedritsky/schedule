package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import java.util.Objects;

/**
 * Information about the date, point of departure and point of arrival
 * indicated in the request.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Search {

    private String date;
    private SearchTo to;
    private SearchFrom from;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SearchTo getTo() {
        return to;
    }

    public void setTo(SearchTo to) {
        this.to = to;
    }

    public SearchFrom getFrom() {
        return from;
    }

    public void setFrom(SearchFrom from) {
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return Objects.equals(date, search.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "Search{" +
                "date='" + date + '\'' +
                ", to=" + to +
                ", from=" + from +
                '}';
    }
}
