package com.fernandez.userauth.repository;

import com.fernandez.userauth.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    // Magic method: Finds a session by the token string
    Optional<Session> findBySessionToken(String sessionToken);
}