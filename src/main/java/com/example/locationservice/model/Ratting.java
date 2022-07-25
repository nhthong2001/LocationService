package com.example.locationservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "Ratting")
public class Ratting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "create_by")
    public String create_by;
    @Column(name = "location_id")
    public String location_id;

    @Column(name = "pointrating")
    public Integer pointRating;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate date;

    @Column(name = "is_deleted")
    public boolean is_deleted;

    public Ratting() {
    }

    public Ratting(Long id, String create_by, String location_id, Integer pointRating, LocalDate date, boolean is_deleted) {
        this.id = id;
        this.create_by = create_by;
        this.location_id = location_id;
        this.pointRating = pointRating;
        this.date = date;
        this.is_deleted = is_deleted;
    }

    public Long getId() {
        return id;
    }

    public String getCreate_by() {
        return create_by;
    }

    public String getLocation_id() {
        return location_id;
    }

    public Integer getPointRating() {
        return pointRating;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }
}
