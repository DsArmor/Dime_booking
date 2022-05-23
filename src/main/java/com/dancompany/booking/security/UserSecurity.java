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
        System.out.println(authentication);
        String username = (String) authentication.getPrincipal();
        return username.equals(userDetailsService.getUserById(id).getUsername());
    }
}
