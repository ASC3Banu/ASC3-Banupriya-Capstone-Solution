package com.ats.service;

import com.ats.entity.User;
import com.ats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void increaseFailedAttempts(User user) {
        int newFailAttempts = user.getFailedAttempts() + 1;
        if (newFailAttempts >= 3) {
            user.setAccountLocked(true);
            user.setLockTime(LocalDateTime.now());
        }
        user.setFailedAttempts(newFailAttempts);
        userRepository.save(user);
    }

    public void resetFailedAttempts(String email) {
        User user = userRepository.findByEmail(email).get();
        user.setFailedAttempts(0);
        userRepository.save(user);
    }

    public boolean unlockWhenTimeExpired(User user) {
        LocalDateTime unlockTime = user.getLockTime().plusMinutes(30);
        if (LocalDateTime.now().isAfter(unlockTime)) {
            user.setAccountLocked(false);
            user.setFailedAttempts(0);
            user.setLockTime(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
