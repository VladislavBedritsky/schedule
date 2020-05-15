package org.kek.data.model.yandexApi;

import java.util.Objects;

public class TransportSubtype {

    private String color;
    private String code;
    private String title;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
        TransportSubtype that = (TransportSubtype) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(code, that.code) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, code, title);
    }

    @Override
    public String toString() {
        return "TransportSubtype{" +
                "color='" + color + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
