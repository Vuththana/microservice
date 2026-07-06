package org.goros.userservice.service;

import org.goros.userservice.entity.response.AppUserResponse;

import java.util.List;
import java.util.UUID;

public interface AppUserService {
    List<AppUserResponse> getAllUsers();
    AppUserResponse getUserById(UUID userId);
    AppUserResponse getUserByEmailOrUsername(String identifier);
}
