package feign;

import org.goros.authenticationservice.dto.AuthUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "USER_SERVICE")
public interface UserClient {
    @GetMapping("/internal/users/identifier/{identifier}")
    AuthUserResponse getByIdentifier(@PathVariable String identifier);
}
