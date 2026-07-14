package org.goros.authenticationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.goros.authenticationservice.feign.UserClient;
import org.goros.authenticationservice.service.AuthService;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    public final UserClient userClient;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        return userClient.findByIdentifier(identifier);
    }
}
