package org.goros.categoryservice.config;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    public final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request) ->
                request.requestMatchers("/api/v1/categories/**", "/api/v1/category/**").authenticated()
                        .anyRequest().permitAll()).build();
    }
}
