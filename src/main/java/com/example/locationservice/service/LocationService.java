package com.example.locationservice.service;


import com.example.locationservice.dto.LocationDto;
import com.example.locationservice.model.Location;
import com.example.locationservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
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
        Optional<Location> rs = locationRepository.findById(id);
        if (rs.get().link_avatar != null || !rs.get().link_avatar.equals("")) {
            StringBuilder linkImg = new StringBuilder("");

            String path = rs.get().link_avatar;

            linkImg.append("data:image/png;base64,");
            try {
                byte[] buffer = Files.readAllBytes(Paths.get(path));
                String encodedString = Base64.getEncoder().encodeToString(buffer);
                linkImg.append(encodedString);
            } catch (Exception e) {
                linkImg = null;
            }
            if (linkImg != null)
                rs.get().link_avatar = linkImg.toString();
        }

        return rs;
    }

    public List<Location> getAllLocation() {
        ArrayList<Location> lists = (ArrayList<Location>) locationRepository.findAll();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).link_avatar != null) {
                StringBuilder linkImg = new StringBuilder("");

                String path = lists.get(i).link_avatar;
                if (!path.equals("")) {
                    linkImg.append("data:image/png;base64,");
                    try {
                        byte[] buffer = Files.readAllBytes(Paths.get(path));
                        String encodedString = Base64.getEncoder().encodeToString(buffer);
                        linkImg.append(encodedString);
                    } catch (Exception e) {
                        linkImg = null;
                    }
                }
                if (linkImg != null)
                    lists.get(i).link_avatar = linkImg.toString();
            }
        }
        return lists;
    }

    public Location addNew(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getLocationByUsername(String username) {
        ArrayList<Location> lists = (ArrayList<Location>) locationRepository.findByUsername(username);

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).link_avatar != null) {
                StringBuilder linkImg = new StringBuilder("");

                String path = lists.get(i).link_avatar;
                if (!path.equals("")) {
                    linkImg.append("data:image/png;base64,");
                    try {
                        byte[] buffer = Files.readAllBytes(Paths.get(path));
                        String encodedString = Base64.getEncoder().encodeToString(buffer);
                        linkImg.append(encodedString);
                    } catch (Exception e) {
                        linkImg = null;
                    }
                }
                if (linkImg != null)
                    lists.get(i).link_avatar = linkImg.toString();
            }
        }
        return lists;
    }

    public Location getLocationByUniqueId(String location_id) {
        return locationRepository.findByUniqueId(location_id);
    }
}
