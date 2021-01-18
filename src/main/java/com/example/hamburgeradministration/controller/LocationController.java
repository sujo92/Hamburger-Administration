package com.example.hamburgeradministration.controller;

import com.example.hamburgeradministration.model.Location;
import com.example.hamburgeradministration.repository.LocationRepository;
import com.example.hamburgeradministration.service.LocationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Log4j2
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations(@RequestParam(required = false) String name) {
        return locationService.getAllLocation(name);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") String id) {
        return locationService.getLocationById(id);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") String id, @RequestBody Location location) {
        return locationService.updateLocation(id,location);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") String id) {
        return locationService.deleteLocation(id);
    }
}
