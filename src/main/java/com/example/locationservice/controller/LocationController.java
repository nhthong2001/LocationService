package com.example.locationservice.controller;

import com.example.locationservice.dto.LocationDto;
import com.example.locationservice.model.Location;
import com.example.locationservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    public ResponseEntity<List<Location>> getAllLocation() {
        return new ResponseEntity<>(locationService.getAllLocation(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Location>> getLocationById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(locationService.getLocationByID(id), HttpStatus.OK);
    }

    @GetMapping("/mypost/{username}")
    public ResponseEntity<List<Location>> getLocationByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(locationService.getLocationByUsername(username), HttpStatus.OK);
    }

    @PostMapping(
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Location> addNew(@ModelAttribute LocationDto locationDto) {
        MultipartFile imageFile = locationDto.image;
        if (imageFile.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

        Path path = Paths.get("uploads/");
        try {
            InputStream inputStream = imageFile.getInputStream();
            Files.copy(inputStream, path.resolve(imageFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
        Path pathImage = Paths.get("uploads/" + imageFile.getOriginalFilename());
        locationDto.link_image = pathImage.toString();

        Location location = new Location(locationDto);


        return new ResponseEntity<>(locationService.addNew(location), HttpStatus.OK);
    }

    @GetMapping("getimage/{locationId}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("locationId") Integer locationId) {
        Optional<Location> lc = locationService.getLocationByID(locationId);
        String linkImg = lc.get().link_avatar;
        if (linkImg == null || linkImg == "") {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        try {
            //Path filename = Paths.get("uploads", photo);
            byte[] buffer = Files.readAllBytes(Paths.get(linkImg));
            ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
        } catch (Exception e) {


        }
        return ResponseEntity.badRequest().build();
    }
}
