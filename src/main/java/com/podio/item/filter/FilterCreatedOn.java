package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterCreatedOn extends Filter {

    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private FilterInterval values;

    public FilterCreatedOn(Date from, Date to) {
        setKey("created_on");
        values = new FilterInterval();
        values.setFrom(from != null ? DATE_FORMAT.format(from) : null);
        values.setTo(to != null ? DATE_FORMAT.format(to) : null);
    }

    @JsonProperty("values")
    public FilterInterval getValues() {
        return values;
    }

    public void setValues(FilterInterval values) {
        this.values = values;
    }
}
