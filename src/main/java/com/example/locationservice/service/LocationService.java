package com.example.locationservice.service;


import com.example.locationservice.model.Location;
import com.example.locationservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Optional<Location> getLocationByID(Integer id) {
        return locationRepository.findById(id);
    }

    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    public Location addNew(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getLocationByUsername(String username) {
        return locationRepository.findByUsername(username);
    }
}
