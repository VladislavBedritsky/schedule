package org.kek.data.model.aviationstackApi;

import java.util.List;
import java.util.Objects;

public class CityResponse {

    private CityPagination pagination;
    private List<CityData> data;

    public CityPagination getPagination() {
        return pagination;
    }

    public void setPagination(CityPagination pagination) {
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
