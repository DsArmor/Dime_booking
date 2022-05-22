package com.dancompany.booking.security;

import com.dancompany.booking.auth.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUserSingleton {
    static private AppUser user;


    public static AppUser getUser() {
        if (user == null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof AppUser)
                user = (AppUser) principal;
            else
                user = null;
            System.out.println(user);
        }
        return user;
    }

    public static void logout() {
        user = null;
    }
}