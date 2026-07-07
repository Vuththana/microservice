package org.goros.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.goros.userservice.entity.request.AppUserRequest;
import org.goros.userservice.entity.request.UpdateUserRequest;
import org.goros.userservice.entity.response.ApiResponse;
import org.goros.userservice.entity.response.ApiResponseVoid;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.service.AppUserService;
import org.goros.userservice.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AppUserController {
    public final AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<AppUserResponse>>> getAllUsers() {
        List<AppUserResponse> users = appUserService.getAllUsers();
        ApiResponse<List<AppUserResponse>> response = ResponseUtil.success("User fetched successfully", users);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<ApiResponse<AppUserResponse>> getUserById(@PathVariable("user-id")UUID userId) {
        ApiResponse<AppUserResponse> response = ResponseUtil.success("User fetched successfully", appUserService.getUserById(userId));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResponse<List<AppUserResponse>>> getUserByEmailOrUsername(@RequestParam String identifier) {
        ApiResponse<List<AppUserResponse>> response = ResponseUtil.success("User fetched successfully", appUserService.getUserByEmailOrUsername(identifier));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/user/{user-id}")
    public ResponseEntity<ApiResponseVoid> deleteUserById(@PathVariable("user-id")UUID userId) {
        appUserService.deleteUserById(userId);
        ApiResponseVoid response = ResponseUtil.successVoid("User deleted successfully");
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<AppUserResponse>> addUser(@RequestBody AppUserRequest request) {
        ApiResponse<AppUserResponse> response = ResponseUtil.success("User created successfully", appUserService.addUser(request));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/user/{user-id}")
    public ResponseEntity<ApiResponseVoid> updateUserById(@PathVariable("user-id") UUID userId, @RequestBody UpdateUserRequest request) {
        appUserService.updateUserById(userId, request);
        ApiResponseVoid response = ResponseUtil.successVoid("User updated successfully");
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
