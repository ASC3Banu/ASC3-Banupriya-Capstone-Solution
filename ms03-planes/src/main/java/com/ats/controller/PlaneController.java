package com.ats.controller;

import com.ats.entity.Plane;
import com.ats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.createPlane(plane));
    }

    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes() {
        return ResponseEntity.ok(planeService.getAllPlanes());
    }

    @GetMapping("/code/{planeCode}")
    public ResponseEntity<Plane> getPlaneByPlaneCode(@PathVariable String planeCode) {
        Optional<Plane> plane = planeService.getPlaneByPlaneCode(planeCode);
        return plane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Plane> addPlane(Plane plane) {
        return null;
    }
}
