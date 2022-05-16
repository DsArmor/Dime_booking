package com.dancompany.booking.controllers;

import com.dancompany.booking.auth.User;
import com.dancompany.booking.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class TempController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public TempController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

}