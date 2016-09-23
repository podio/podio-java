package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ItemFilter {

    private String sortBy;
    private Boolean sortDesc;
    private Integer limit;
    private Integer offset;
    private List<Filter> filters;

    public ItemFilter() {
        filters = new ArrayList<Filter>();
    }

    /**
     * Creates a copy (actual filters are only shallow copy!)
     * @param filter
     */
    public ItemFilter(ItemFilter filter) {
        this();
        sortBy = filter.getSortBy();
        sortDesc = filter.getSortDesc();
        limit = filter.getLimit();
        offset = filter.getOffset();
        filters = filter.getFilters();
    }


    @JsonProperty("sort_by")
    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @JsonProperty("sort_desc")
    public Boolean getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(Boolean sortDesc) {
        this.sortDesc = sortDesc;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonProperty("filters")
    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }
}
