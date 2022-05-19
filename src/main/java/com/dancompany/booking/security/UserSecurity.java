package com.dancompany.booking.security;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.implementation.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserSecurity {

    private final UserDetailsServiceImpl userDetailsService;

    public boolean hasUserId(Authentication authentication, Long id) {
        Object principal = authentication.getPrincipal();
        String username;
        String password = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            password = ((UserDetails)principal).getPassword();
        } else {
            username = principal.toString();
        }
        AppUser user = userDetailsService.getUserById(id);
        return user.getEmail().equals(username) && Objects.requireNonNull(password).equals(user.getPassword());
    }
}
