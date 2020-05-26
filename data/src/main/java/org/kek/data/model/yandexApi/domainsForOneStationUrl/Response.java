package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.Pagination;

import java.util.List;
import java.util.Objects;

/**
 *
 * Response info for one station by date from api.rasp.yandex.net REST API.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Response {

    private String date;
    private Pagination pagination;
    private Station station;
    @JsonProperty("schedule")
    private List<Schedule> schedules;
    @JsonProperty("schedule_direction")
    private ScheduleDirection scheduleDirection;
    private Directions directions;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(date, response.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "Response{" +
                "date='" + date + '\'' +
                ", pagination=" + pagination +
                ", station=" + station +
                ", schedules=" + schedules +
                '}';
    }
}
