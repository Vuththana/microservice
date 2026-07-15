package org.goros.userservice.service;

import org.goros.userservice.entity.request.AppUserRequest;
import org.goros.userservice.entity.request.UpdateUserRequest;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.entity.response.InternalAppUserResponse;

import java.util.List;
import java.util.UUID;

public interface AppUserService {
    List<AppUserResponse> getAllUsers();
    AppUserResponse getUserById(UUID userId);
    List<AppUserResponse> getUserByEmailOrUsername(String identifier);
    void deleteUserById(UUID userId);
    AppUserResponse addUser(AppUserRequest request);
    void updateUserById(UUID userId, UpdateUserRequest request);
    InternalAppUserResponse getUserByIdentifier(String email);
}
