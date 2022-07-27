package com.example.locationservice.service;


import com.example.locationservice.model.Location;
import com.example.locationservice.model.Ratting;
import com.example.locationservice.repository.RattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RattingService {
    private RattingRepository rattingRepository;
    private LocationService locationService;

    @Autowired
    public RattingService(RattingRepository rattingRepository, LocationService locationService) {
        this.rattingRepository = rattingRepository;
        this.locationService = locationService;
    }


    public Optional<Ratting> getRatting(String location_id, String create_by) {
        return rattingRepository.findRatting(location_id, create_by);
    }

    public List<Ratting> getAllRatting(String locationID) {
        return rattingRepository.findAllByLocationID(locationID);
    }

    public Ratting addNew(Ratting ratting) {
        Location lc = locationService.getLocationByUniqueId(ratting.location_id);
        int n = rattingRepository.findAllByLocationID(ratting.location_id).size();
        lc.rating = (lc.rating + ratting.pointRating) / (n + 1);
        locationService.addNew(lc);
        return rattingRepository.save(ratting);
    }

    public int updateRatting(Ratting ratting) {
        return rattingRepository.updateRatting(ratting.getPointRating(), ratting.getCreate_by());
    }
}
