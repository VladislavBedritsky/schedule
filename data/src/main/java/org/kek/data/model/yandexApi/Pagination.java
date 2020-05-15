package org.kek.data.model.yandexApi;

import java.util.Objects;

public class Pagination {

    private Integer total;
    private Integer limit;
    private Integer offset;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagination that = (Pagination) o;
        return Objects.equals(total, that.total) &&
                Objects.equals(limit, that.limit) &&
                Objects.equals(offset, that.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, limit, offset);
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "total=" + total +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
