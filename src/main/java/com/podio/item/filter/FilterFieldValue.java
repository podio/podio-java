package com.podio.item.filter;

public abstract class FilterFieldValue<VALUES> extends Filter<VALUES> {

    public FilterFieldValue(int fieldId) {
        super(String.valueOf(fieldId));
    }
}
