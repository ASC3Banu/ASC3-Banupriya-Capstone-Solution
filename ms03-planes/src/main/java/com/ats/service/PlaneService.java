package com.ats.service;

import com.ats.entity.Plane;
import com.ats.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public Plane createPlane(Plane plane) {
        plane.setPlaneCode(generatePlaneCode());
        return planeRepository.save(plane);
    }



    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Optional<Plane> getPlaneById(Long id) {
        return planeRepository.findById(id);
    }

    public Optional<Plane> getPlaneByPlaneCode(String planeCode) {
        return planeRepository.findByPlaneCode(planeCode);
    }

    private String generatePlaneCode() {
        Long count = planeRepository.count();
        return String.format("P%04d", count + 1);
    }

    public void deletePlane(Long id) {
        Optional<Plane> plane = planeRepository.findById(id);
        if (plane.isPresent()) {
            planeRepository.delete(plane.get());
        } else {
            throw new RuntimeException("Plane not found with id " + id);
        }
    }


//    public Object addPlane(Plane plane) {
//        return null;
//    }
}
