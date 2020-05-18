package org.kek.data.model.yandexApi;

import java.util.Objects;

/**
 * Vehicle subtype information.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class TransportSubtype {

    private String color;
    /**
     * The transport subtype code for the type
     */
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
