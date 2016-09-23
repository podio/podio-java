package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class Filter {

    private String key;

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
