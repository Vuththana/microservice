package org.goros.authenticationservice.config;

import org.goros.authenticationservice.dto.AuthUserResponse;
import org.goros.authenticationservice.feign.UserClient;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserClient userClient;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        AuthUserResponse user = userClient.getByIdentifier(identifier);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
