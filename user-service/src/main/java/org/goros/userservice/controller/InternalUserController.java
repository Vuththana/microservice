package org.goros.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.goros.userservice.entity.request.AppUserRequest;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.entity.response.InternalAppUserResponse;
import org.goros.userservice.service.AppUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalUserController {
    public final AppUserService appUserService;
    @PostMapping("/")
    public AppUserResponse createUser(@RequestBody AppUserRequest request) {
        return appUserService.addUser(request);
    }

    @GetMapping("/identifier/{identifier}")
    public InternalAppUserResponse findByEmail(@PathVariable String identifier) {
        return appUserService.getUserByIdentifier(identifier);
    }
}
