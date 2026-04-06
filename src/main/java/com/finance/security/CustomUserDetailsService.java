package com.finance.security;

import org.springframework.security.core.userdetails.*;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
    }
}