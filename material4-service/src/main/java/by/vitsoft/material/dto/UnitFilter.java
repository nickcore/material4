package by.vitsoft.material.dto;

public class UnitFilter {
    Long pageIndex;
    long pageSize;
    long pageCount;

    Integer sortIndex;
    String sortOrder;
    public Long getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }
    public long getPageSize() {
        return pageSize;
    }
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getSortIndex() {
        return sortIndex;
    }
    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setRowNum(Long rowNum) {
        
    }

    public Long startRowIndex() {
        return null;
    }
    public Long endRowIndex() {
        return null;
    }
}
