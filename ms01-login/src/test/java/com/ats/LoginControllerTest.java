package com.ats;

import com.ats.controller.LoginController;
import com.ats.entity.User;
import com.ats.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LoginControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess() {
        User user = new User();
        user.setEmail("admin541@example.com");
        user.setPassword("P@ssw0rd1");
        user.setFailedAttempts(0);
        user.setAccountLocked(false);

        when(userService.findByEmail("admin541@example.com")).thenReturn(Optional.of(user));
        when(userService.unlockWhenTimeExpired(user)).thenReturn(false);

        ResponseEntity<String> response;
        response = loginController.login("admin541@example.com", "P@ssw0rd1");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Login successful. Welcome to the application menu.", response.getBody());
    }

    @Test
    void testLoginIncorrectPassword() {
        User user = new User();
        user.setEmail("admin@example.com");
        user.setPassword("WrongPassword");
        user.setFailedAttempts(1);
        user.setAccountLocked(false);

        when(userService.findByEmail("admin@example.com")).thenReturn(Optional.of(user));

        ResponseEntity<String> response = loginController.login("admin@example.com", "WrongPassword");

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid credentials. Attempt 1 of 3.", response.getBody());
    }

    @Test
    void testLoginAccountLocked() {
        User user = new User();
        user.setEmail("admin@example.com");
        user.setPassword("Admin@123");
        user.setFailedAttempts(3);
        user.setAccountLocked(true);

        when(userService.findByEmail("admin@example.com")).thenReturn(Optional.of(user));

        ResponseEntity<String> response = loginController.login("admin@example.com", "Admin@123");

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Account locked. Please try again later.", response.getBody());
    }

    @Test
    void testLoginUserNotFound() {
        when(userService.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        ResponseEntity<String> response = loginController.login("nonexistent@example.com", "Password@123");

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("User not found.", response.getBody());
    }
}

