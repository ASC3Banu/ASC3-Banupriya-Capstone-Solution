package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.entity.Plane;

import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Optional<Plane> findByPlaneCode(String planeCode);
}
