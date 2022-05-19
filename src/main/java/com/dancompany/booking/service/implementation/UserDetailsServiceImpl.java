package com.dancompany.booking.service.implementation;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.auth.ApplicationUser;
import com.dancompany.booking.auth.User;
import com.dancompany.booking.repository.UserRepository;
import com.dancompany.booking.security.PasswordConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect email"));
    }

    public String signUp(AppUser appUser) {
        userRepository.findByEmail(appUser.getEmail()).ifPresent(
                (u) -> {throw new IllegalStateException(String.format("User with username %s exists", appUser.getEmail()));} // todo add custom exceptions
        );

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
        return "login";
    }
}
