package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class Filter<VALUES> {

    private final String key;

    Filter(String key) {
        this.key = key;
    }

    @JsonProperty("values")
    public abstract VALUES getValues();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }
}
