package org.goros.userservice.repository;

import org.goros.userservice.entity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    @Query("""
    SELECT au
    FROM AppUser au
    WHERE LOWER(au.email) LIKE LOWER(CONCAT('%', :identifier, '%'))
       OR LOWER(au.username) LIKE LOWER(CONCAT('%', :identifier, '%'))
    """)
    Optional<List<AppUser>> findByIdentifier(@Param("identifier") String identifier);

    @Modifying
    @Query("DELETE FROM AppUser au WHERE au.userId = :userId")
    void deleteUserById(UUID  userId);
}
