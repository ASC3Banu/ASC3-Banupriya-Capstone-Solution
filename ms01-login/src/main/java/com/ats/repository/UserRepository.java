package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ats.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
