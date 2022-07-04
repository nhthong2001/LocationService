package com.example.locationservice.model;

import java.io.Serializable;

public class RattingId implements Serializable {
    private String  create_by;

    private String  location_id;

    // default constructor

    public RattingId() {
    }

    public RattingId(String location_id, String create_by) {
        this.location_id = location_id;
        this.create_by = create_by;
    }
}
