package com.example.locationservice.service;


import com.example.locationservice.model.Ratting;
import com.example.locationservice.repository.RattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RattingService {
    private RattingRepository rattingRepository;

    @Autowired
    public RattingService(RattingRepository rattingRepository) {
        this.rattingRepository = rattingRepository;
    }

    public Optional<Ratting> getRatting(String location_id, String create_by) {
        return rattingRepository.findRatting(location_id, create_by);
    }

    public List<Ratting> getAllRatting(String locationID) {
        return rattingRepository.findAllByLocationID(locationID);
    }

    public Ratting addNew(Ratting ratting) {
        return rattingRepository.save(ratting);
    }
}
