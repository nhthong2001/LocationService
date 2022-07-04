package com.example.locationservice.controller;

import com.example.locationservice.model.Comment;
import com.example.locationservice.model.Ratting;
import com.example.locationservice.service.CommentService;
import com.example.locationservice.service.RattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location/ratting")
public class RattingController {
    private final RattingService rattingService;

    @Autowired
    public RattingController(RattingService rattingService) {
        this.rattingService = rattingService;
    }

    @GetMapping("/{location_id}")
    public ResponseEntity<List<Ratting>> getAllRattingByLocationID(@PathVariable("location_id") String location_id) {
        return new ResponseEntity<>(rattingService.getAllRatting(location_id), HttpStatus.OK);
    }

    @GetMapping("/{location_id}/{create_by}")
    public ResponseEntity<Optional<Ratting>> getAllRattingByLocationID(@PathVariable("location_id") String location_id, @PathVariable("create_by") String create_by) {
        return new ResponseEntity<>(rattingService.getRatting(location_id, create_by), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ratting> addNew(@RequestBody Ratting ratting) {
        return new ResponseEntity<>(rattingService.addNew(ratting), HttpStatus.OK);
    }


}
