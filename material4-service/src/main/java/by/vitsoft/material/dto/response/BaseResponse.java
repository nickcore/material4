package by.vitsoft.material.dto.response;

import java.util.Collection;

public class BaseResponse<T> {
    Long page = 1L;
    Long total;
    long records;
    Collection<T> data;

    public BaseResponse() {
    }

    public BaseResponse(Long page, Long total, long records) {
        this.page = page;
        this.total = total;
        this.records = records;
    }

    public BaseResponse(Long page, Long total, long records, Collection<T> data) {
        this.page = page;
        this.total = total;
        this.records = records;
        this.data = data;
    }

    public Long getPage() {
        return page;
    }
    public Long getTotal() {
        return total;
    }
    public long getRecords() {
        return records;
    }
    public Collection<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BaseResponse [data=" + data + ", page=" + page + ", records=" + records
                + ", total=" + total + "]";
    }
}
