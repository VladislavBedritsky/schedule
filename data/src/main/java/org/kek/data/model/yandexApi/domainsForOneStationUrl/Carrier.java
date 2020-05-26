package org.kek.data.model.yandexApi.domainsForOneStationUrl;

import org.kek.data.model.yandexApi.Codes;

import java.util.Objects;

/**
 *
 * Information about the carrier.
 *
 * @version 1.01 26 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Carrier {

    /**
     * Flight number.
     */
    private Integer code;
    private Codes codes;
    private String title;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Codes getCodes() {
        return codes;
    }

    public void setCodes(Codes codes) {
        this.codes = codes;
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
        Carrier carrier = (Carrier) o;
        return Objects.equals(code, carrier.code) &&
                Objects.equals(codes, carrier.codes) &&
                Objects.equals(title, carrier.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codes, title);
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "code='" + code + '\'' +
                ", codes=" + codes +
                ", title='" + title + '\'' +
                '}';
    }
}
