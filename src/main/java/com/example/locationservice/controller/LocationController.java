package com.example.locationservice.controller;

import com.example.locationservice.model.Location;
import com.example.locationservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllLocation(){
        return new ResponseEntity<>(locationService.getAllLocation(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Location>> getLocationById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(locationService.getLocationByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> addNew(@RequestBody Location location){
        return new ResponseEntity<>(locationService.addNew(location), HttpStatus.OK);
    }
}
