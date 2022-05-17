package com.dancompany.booking.controllers;

import com.dancompany.booking.auth.User;
import com.dancompany.booking.service.implementation.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public RegistrationController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping
    public String registration(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userDetailsServiceImpl.signUp(user);
    }

}
