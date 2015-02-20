package com.podio.contact;

import org.codehaus.jackson.annotate.JsonProperty;

public class ContactCreateResponse {

        private int id;

        public int getId() {
                return id;
        }

        @JsonProperty("profile_id")
        public void setId(int id) {
                this.id = id;
        }

}
