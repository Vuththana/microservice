package org.goros.authenticationservice.feign;

import org.goros.authenticationservice.dto.AuthUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/internal/users/identifier/{identifier}")
    AuthUserResponse getByIdentifier(@PathVariable String identifier);
}
