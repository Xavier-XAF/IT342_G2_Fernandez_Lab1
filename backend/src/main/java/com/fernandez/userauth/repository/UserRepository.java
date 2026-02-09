package com.fernandez.userauth.repository;

import com.fernandez.userauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Magic method: Spring automatically writes the SQL for "SELECT * FROM users WHERE email = ?"
    Optional<User> findByEmail(String email);
}


