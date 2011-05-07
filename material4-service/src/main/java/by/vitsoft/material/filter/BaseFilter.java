package by.vitsoft.material.filter;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

public class BaseFilter {
    /** The requested page. By default grid sets this to 1. */
    private Integer page;
    /**
     * How many rows we want to have into the grid - rowNum parameter in the
     * grid
     */
    private Integer rows;
    /**
     * Index row - i.e. user click to sort. At first time sortname parameter -
     * after that the index from colModel
     */
    private String sidx;
    /** Sorting order - at first time sortorder */
    private String sord;

    private RuleSet ruleSet;

    public BaseFilter() {
    }

    public BaseFilter(Integer page, Integer rows, String sidx, String sort) {
        this.page = page;
        this.rows = rows;
        this.sidx = sidx;
        this.sord = sort;
    }

    public BaseFilter(Integer page, Integer rows, String sidx, String sord, RuleSet ruleSet) {
        this.page = page;
        this.rows = rows;
        this.sidx = sidx;
        this.sord = sord;
        this.ruleSet = ruleSet;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }
}
