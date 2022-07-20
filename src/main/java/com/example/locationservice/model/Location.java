package com.example.locationservice.model;

import com.example.locationservice.dto.LocationDto;

import javax.persistence.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "unique_id")
    public String unique_id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "link_avatar")
    public String link_avatar;

    @Column(name = "rating")
    public Float rating;

    @Column(name = "address")
    public String address;

    @Column(name = "phone_number")
    public String phone_number;

    @Column(name = "website")
    public String website;

    @Column(name = "time_open")
    public LocalTime time_open;

    @Column(name = "time_close")
    public LocalTime time_close;

    @Column(name = "is_private")
    public boolean is_private;

    @Column(name = "region_id")
    public String region_id;

    @Column(name = "type_id")
    public String type_id;

    @Column(name = "is_deleted")
    public boolean is_deleted;

    public Location() {
    }

    public Location(Integer id, String create_by, String unique_id, String name, String description, String link_avatar, Float rating, String address, String phone_number, String website, LocalTime time_open, LocalTime time_close, boolean is_private, String region_id, String type_id, boolean is_deleted) {
        this.id = id;
        this.create_by = create_by;
        this.unique_id = unique_id;
        this.name = name;
        this.description = description;
        this.link_avatar = link_avatar;
        this.rating = rating;
        this.address = address;
        this.phone_number = phone_number;
        this.website = website;
        this.time_open = time_open;
        this.time_close = time_close;
        this.is_private = is_private;
        this.region_id = region_id;
        this.type_id = type_id;
        this.is_deleted = is_deleted;
    }

    public Location(LocationDto locationDto) {
        this.create_by = locationDto.create_by;
        this.name = locationDto.name;
        this.description = locationDto.description;
        this.link_avatar = locationDto.link_image;
        this.rating = locationDto.rating;
        this.address = locationDto.address;
        this.phone_number = locationDto.phone_number;
        this.website = locationDto.website;
        this.time_open = LocalTime.parse(locationDto.time_open, DateTimeFormatter.ofPattern("HH:mm"));
        this.time_close = LocalTime.parse(locationDto.time_close, DateTimeFormatter.ofPattern("HH:mm"));
        this.is_private = false;
        this.type_id = locationDto.type_id;
        this.is_deleted = false;
    }

    public Integer getId() {
        return id;
    }

    public String getCreate_by() {
        return create_by;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLink_avatar() {
        return link_avatar;
    }

    public Float getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getWebsite() {
        return website;
    }

    public LocalTime getTime_open() {
        return time_open;
    }

    public LocalTime getTime_close() {
        return time_close;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public String getRegion_id() {
        return region_id;
    }

    public String getType_id() {
        return type_id;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    @PrePersist
    private void generateUniqueId() {
        this.unique_id = UUID.randomUUID().toString();
    }

}