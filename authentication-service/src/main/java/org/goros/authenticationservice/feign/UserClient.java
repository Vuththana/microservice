package org.goros.authenticationservice.feign;

import org.goros.authenticationservice.dto.AppUserRequest;
import org.goros.authenticationservice.dto.AppUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @PostMapping("/internal/users")
    AppUserResponse createUser(AppUserRequest request);

    @GetMapping("/internal/users/identifier/{identifier}")
    UserDetails findByIdentifier(@PathVariable String identifier);
}
