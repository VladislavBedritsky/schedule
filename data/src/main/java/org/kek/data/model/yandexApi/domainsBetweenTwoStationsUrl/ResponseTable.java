package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.Pagination;

import java.util.List;

/**
 *  Response between two points by date from api.rasp.yandex.net REST API
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class ResponseTable {

    private Pagination pagination;
    @JsonProperty("interval_segments")
    private List<IntervalSegments> intervalSegments;
    private List<Segments> segments;
    private Search search;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<IntervalSegments> getIntervalSegments() {
        return intervalSegments;
    }

    public void setIntervalSegments(List<IntervalSegments> intervalSegments) {
        this.intervalSegments = intervalSegments;
    }

    public List<Segments> getSegments() {
        return segments;
    }

    public void setSegments(List<Segments> segments) {
        this.segments = segments;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "ResponseTable{" +
                "pagination=" + pagination +
                ", intervalSegments=" + intervalSegments +
                ", segments=" + segments +
                ", search=" + search +
                '}';
    }
}
