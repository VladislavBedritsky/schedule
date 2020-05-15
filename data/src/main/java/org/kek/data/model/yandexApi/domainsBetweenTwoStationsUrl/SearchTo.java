package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SearchTo {
    private String code;
    private String type;
    @JsonProperty("popular_title")
    private String popularTitle;
    @JsonProperty("short_title")
    private String shortTitle;
    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPopularTitle() {
        return popularTitle;
    }

    public void setPopularTitle(String popularTitle) {
        this.popularTitle = popularTitle;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
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
        SearchTo searchTo = (SearchTo) o;
        return Objects.equals(code, searchTo.code) &&
                Objects.equals(type, searchTo.type) &&
                Objects.equals(popularTitle, searchTo.popularTitle) &&
                Objects.equals(shortTitle, searchTo.shortTitle) &&
                Objects.equals(title, searchTo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, popularTitle, shortTitle, title);
    }

    @Override
    public String toString() {
        return "SearchTo{" +
                "code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", popularTitle='" + popularTitle + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
