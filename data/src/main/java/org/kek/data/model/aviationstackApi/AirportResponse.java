package org.kek.data.model.aviationstackApi;

import java.util.List;
import java.util.Objects;

public class AirportResponse {

    private Pagination pagination;
    private List<AirportData> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<AirportData> getData() {
        return data;
    }

    public void setData(List<AirportData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportResponse that = (AirportResponse) o;
        return Objects.equals(pagination, that.pagination) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, data);
    }

    @Override
    public String toString() {
        return "AirportResponse{" +
                "pagination=" + pagination +
                ", data=" + data +
                '}';
    }
}
