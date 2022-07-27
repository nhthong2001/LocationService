package com.example.locationservice.dto;


import com.example.locationservice.model.Comment;

public class CommentDto {
    public Long id;

    public String create_by;

    public String location_id;

    public String content;

    public Integer point;

    public boolean is_deleted;

    public CommentDto(Comment c) {
        this.id = c.id;
        this.create_by = c.create_by;
        this.location_id = c.location_id;
        this.content = c.content;
        this.point = -1;
        this.is_deleted = c.is_deleted;
    }

    public CommentDto() {
    }
}
