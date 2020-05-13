package org.kek.data.model.aviationstackApi;

import java.util.Objects;

public class CityPagination {

    private Long limit;
    private Integer offset;
    private Long count;
    private Long total;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityPagination that = (CityPagination) o;
        return Objects.equals(limit, that.limit) &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(count, that.count) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset, count, total);
    }

    @Override
    public String toString() {
        return "CityPagination{" +
                "limit=" + limit +
                ", offset=" + offset +
                ", count=" + count +
                ", total=" + total +
                '}';
    }
}
