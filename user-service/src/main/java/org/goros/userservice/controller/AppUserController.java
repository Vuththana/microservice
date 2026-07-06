package org.goros.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.goros.userservice.entity.response.ApiResponse;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.service.AppUserService;
import org.goros.userservice.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
