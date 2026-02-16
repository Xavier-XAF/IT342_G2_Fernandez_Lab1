package com.fernandez.userauth.controller;

import com.fernandez.userauth.dto.LoginRequest;
import com.fernandez.userauth.dto.RegisterRequest;
import com.fernandez.userauth.model.User;
import com.fernandez.userauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow React Frontend to talk to us later
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint: POST /auth/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            User newUser = authService.register(
                    request.getEmail(),
                    request.getPassword(),
                    request.getFirstname(),
                    request.getLastname()
            );
            return ResponseEntity.ok(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint: POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            String token = authService.login(request.getEmail(), request.getPassword());

            // Return token in a JSON object
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
