package com.fernandez.userauth.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

@Data                  // Generates Getters, Setters, toString, equals, hashcode
@NoArgsConstructor     // Generates a no-args constructor (Required by JPA)
@AllArgsConstructor    // Generates a constructor with all arguments
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Active'")
    private Status status = Status.Active;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public enum Status {
        Active, Inactive, Banned
    }
}
