package com.dancompany.booking.service.implementation;

import com.dancompany.booking.auth.ApplicationUser;
import com.dancompany.booking.auth.User;
import com.dancompany.booking.repository.UserRepository;
import com.dancompany.booking.security.PasswordConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect email"));
        return ApplicationUser.fromUser(user);
    }

    public String signUp(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(
                (u) -> {throw new IllegalStateException(String.format("User with username %s exists", user.getEmail()));} // todo add custom exceptions
        );

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login";
    }
}
