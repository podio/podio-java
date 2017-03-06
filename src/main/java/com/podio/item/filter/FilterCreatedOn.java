package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterCreatedOn extends Filter<FilterInterval> {

    /** non-static to allow for multi threading */
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final FilterInterval values;

    public FilterCreatedOn(Date from, Date to) {
        super("created_on");
        values = new FilterInterval();
        values.setFrom(from != null ? DATE_FORMAT.format(from) : null);
        values.setTo(to != null ? DATE_FORMAT.format(to) : null);
    }

    @Override
    @JsonProperty("values")
    public FilterInterval getValues() {
        return values;
    }
}
