package com.fernandez.userauth.repository;


import com.fernandez.userauth.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // No custom methods needed yet, standard CRUD is enough
}
