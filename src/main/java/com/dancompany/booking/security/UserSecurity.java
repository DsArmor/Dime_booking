package com.dancompany.booking.security;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.implementation.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSecurity {

    private final UserDetailsServiceImpl userDetailsService;

    public boolean hasUserId(Authentication authentication, Long id) {
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        userDetailsService.getUserById(id);
        return userDetailsService.getUserById(id).getEmail().equals(username);
    }
}
