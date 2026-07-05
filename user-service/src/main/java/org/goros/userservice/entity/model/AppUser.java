package org.goros.userservice.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID userId;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
