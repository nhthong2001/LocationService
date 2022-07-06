package com.example.locationservice.controller;

import com.example.locationservice.model.Comment;
import com.example.locationservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{location_id}")
    public ResponseEntity<List<Comment>> getAllCommentByLocationID(@PathVariable("location_id") String location_id) {
        return new ResponseEntity<>(commentService.getAllCommentByLocationID(location_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> addNew(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.addNew(comment), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.update(comment), HttpStatus.OK);
    }

    @PostMapping("/update1")
    public ResponseEntity<Integer> updateComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.updateComment(comment), HttpStatus.OK);
    }
}
