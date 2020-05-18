package org.kek.data.model.yandexApi;

import java.util.Objects;

/**
 *
 * Information about carrier codes in other encoding systems
 * supported by Yandex Schedules.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Codes {

    private String icao;
    private String sirena;
    private String iata;

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getSirena() {
        return sirena;
    }

    public void setSirena(String sirena) {
        this.sirena = sirena;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Codes codes = (Codes) o;
        return Objects.equals(icao, codes.icao) &&
                Objects.equals(sirena, codes.sirena) &&
                Objects.equals(iata, codes.iata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icao, sirena, iata);
    }

    @Override
    public String toString() {
        return "Codes{" +
                "icao='" + icao + '\'' +
                ", sirena='" + sirena + '\'' +
                ", iata='" + iata + '\'' +
                '}';
    }
}
