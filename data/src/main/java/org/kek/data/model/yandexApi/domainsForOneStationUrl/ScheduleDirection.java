package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import java.util.Objects;

/**
 * Info about code and name of the requested flight directions.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class ScheduleDirection {

    private String code;
    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDirection that = (ScheduleDirection) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title);
    }

    @Override
    public String toString() {
        return "ScheduleDirection{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
