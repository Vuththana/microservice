package org.goros.userservice.repository;

import org.goros.userservice.entity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    @Query("SELECT au FROM AppUser au WHERE au.email = :identifier OR au.username = :identifier")
    Optional<AppUser> findByIdentifier(String identifier);
}
