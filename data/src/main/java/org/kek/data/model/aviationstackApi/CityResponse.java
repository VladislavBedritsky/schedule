package org.kek.data.model.aviationstackApi;

import java.util.List;
import java.util.Objects;

/**
 *
 * City response from aviationstack.com REST API
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class CityResponse {

    private Pagination pagination;
    private List<CityData> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<CityData> getData() {
        return data;
    }

    public void setData(List<CityData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityResponse that = (CityResponse) o;
        return Objects.equals(pagination, that.pagination) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, data);
    }

    @Override
    public String toString() {
        return "CityResponse{" +
                "pagination=" + pagination +
                ", data=" + data +
                '}';
    }
}
