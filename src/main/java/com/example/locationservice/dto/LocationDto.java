package com.example.locationservice.dto;

import org.springframework.web.multipart.MultipartFile;

public class LocationDto {
    public String create_by;

    public String name;
    public String description;
    public String link_image;
    public MultipartFile image;
    public Float rating;
    public String address;
    public String phone_number;
    public String website;
    public String time_open;
    public String time_close;
    public String type_id;

    public LocationDto(String create_by, String name, String description, String link_image, MultipartFile image, Float rating, String address, String phone_number, String website, String time_open, String time_close, String type_id) {
        this.create_by = create_by;
        this.name = name;
        this.description = description;
        this.link_image = link_image;
        this.image = image;
        this.rating = rating;
        this.address = address;
        this.phone_number = phone_number;
        this.website = website;
        this.time_open = time_open;
        this.time_close = time_close;
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "create_by='" + create_by + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", link_image='" + link_image + '\'' +
                ", image=" + image +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", website='" + website + '\'' +
                ", time_open='" + time_open + '\'' +
                ", time_close='" + time_close + '\'' +
                ", type_id='" + type_id + '\'' +
                '}';
    }
}
