package com.deoudegracht.deoudegracht.security;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {
    public boolean hasUsername(Authentication authentication, String username) {
        return authentication.getName().equals(username);
    }
}
