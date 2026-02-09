package com.fernandez.userauth.service;

import com.fernandez.userauth.model.Session;
import com.fernandez.userauth.model.User;
import com.fernandez.userauth.model.UserProfile;
import com.fernandez.userauth.repository.SessionRepository;
import com.fernandez.userauth.repository.UserProfileRepository;
import com.fernandez.userauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // --- REGISTER FEATURE ---
    public User register(String email, String rawPassword, String firstname, String lastname) {
        // 1. Check if email already exists
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        // 2. Create User (Hash password!)
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPasswordHash(passwordEncoder.encode(rawPassword)); // SRS: Encrypt before storing
        newUser.setStatus(User.Status.Active);

        User savedUser = userRepository.save(newUser);

        // 3. Create Empty Profile
        UserProfile profile = new UserProfile();
        profile.setUser(savedUser);
        profile.setFirstname(firstname);
        profile.setLastname(lastname);
        userProfileRepository.save(profile);

        return savedUser;
    }

    // --- LOGIN FEATURE ---
    public String login(String email, String rawPassword) {
        // 1. Find User
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();

        // 2. Validate Password
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        // 3. Create Session Token
        String token = UUID.randomUUID().toString(); // Generate unique token
        Session session = new Session();
        session.setUser(user);
        session.setSessionToken(token);
        session.setExpiresAt(LocalDateTime.now().plusHours(24)); // 24 hour session

        sessionRepository.save(session);

        return token; // Return token to user
    }
}
