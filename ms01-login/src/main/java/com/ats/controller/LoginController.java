package com.ats.controller;

//import com.ats.client.BookingClient;
import com.ats.client.Booking;
import com.ats.client.BookingClient;
import com.ats.entity.User;
import com.ats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;
//    @Autowired
//    private BookingClient bookingClient;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
//        Optional<User> optionalUser = userService.findByEmail(email);
//
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//
//            if (user.isAccountLocked()) {
//                if (userService.unlockWhenTimeExpired(user)) {
//                    return ResponseEntity.badRequest().body("Account was locked, now unlocked. Please try logging in again.");
//                } else {
//                    return ResponseEntity.badRequest().body("Account locked. Please try again later.");
//                }
//            }
//
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                userService.resetFailedAttempts(email);
//                return ResponseEntity.ok("Login successful. Welcome to the application menu.");
//            } else {
//                userService.increaseFailedAttempts(user);
//                return ResponseEntity.badRequest().body("Invalid credentials. Attempt " + user.getFailedAttempts() + " of 3.");
//            }
//        }
//
//        return ResponseEntity.badRequest().body("User not found.");
//    }
//@PostMapping("/login")
//public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//    String email = loginRequest.getEmail();
//    String password = loginRequest.getPassword();
//
//    Optional<User> optionalUser = userService.findByEmail(email);
//
//    if (optionalUser.isPresent()) {
//        User user = optionalUser.get();
//
//        if (user.isAccountLocked()) {
//            if (userService.unlockWhenTimeExpired(user)) {
//                return ResponseEntity.badRequest().body("Account was locked, now unlocked. Please try logging in again.");
//            } else {
//                return ResponseEntity.badRequest().body("Account locked. Please try again later.");
//            }
//        }
//
//        if (passwordEncoder.matches(password, user.getPassword())) {
//            userService.resetFailedAttempts(email);
//            //String bookings = bookingClient.getBookingsForUser(user.getId());
//            //return ResponseEntity.ok("Login successful. Booking Details: " + bookings);
//            return ResponseEntity.ok("Login successful. Welcome to the application menu.");
//        } else {
//            userService.increaseFailedAttempts(user);
//            return ResponseEntity.badRequest().body("Invalid credentials. Attempt " + user.getFailedAttempts() + " of 3.");
//        }
//    }
//
//    return ResponseEntity.badRequest().body("User not found.");
//}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Optional<User> optionalUser = userService.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (passwordEncoder.matches(password, user.getPassword())) {
                userService.resetFailedAttempts(email);
                BookingClient bookingClient = null;
                Booking booking = bookingClient.getBookingById("exampleBookingId"); // Example booking ID
                return ResponseEntity.ok("Login successful. Booking: " + booking.toString());
            } else {
                userService.increaseFailedAttempts(user);
                return ResponseEntity.badRequest().body("Invalid credentials.");
            }
        }

        return ResponseEntity.badRequest().body("User not found.");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    //public ResponseEntity<String> login(String mail, String s) {

        //return null;
    //}
}
