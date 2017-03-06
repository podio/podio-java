package com.podio.item.filter;

import org.codehaus.jackson.annotate.JsonProperty;

public class FilterInterval {

    private String from;
    private String to;

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
