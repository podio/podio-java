package com.podio.item.filter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterDateField extends FilterFieldValue<FilterInterval> {

    /** non-static to allow for multi threading */
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final FilterInterval values;

    public FilterDateField(int fieldId, Date from, Date to) {
        super(fieldId);
        values = new FilterInterval();
        values.setFrom(from != null ? DATE_FORMAT.format(from) : null);
        values.setTo(to != null ? DATE_FORMAT.format(to) : null);
    }

    @Override
    public FilterInterval getValues() {
        return values;
    }
}
