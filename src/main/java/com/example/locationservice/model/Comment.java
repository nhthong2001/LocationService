package com.example.locationservice.model;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "location_id")
    public String location_id;

    @Column(name = "content")
    public String content;

    @Column(name = "is_deleted")
    public boolean is_deleted;

    public Comment() {
    }

    public Comment(String create_by, String location_id, String content, boolean is_deleted) {
        this.create_by = create_by;
        this.location_id = location_id;
        this.content = content;
        this.is_deleted = is_deleted;
    }

    public Comment(Long id, String create_by, String location_id, String content, boolean is_deleted) {
        this.id = id;
        this.create_by = create_by;
        this.location_id = location_id;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }
}
