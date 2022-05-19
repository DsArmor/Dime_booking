package com.dancompany.booking.model.mapper;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.auth.Role;
import com.dancompany.booking.model.dto.request.HotelRequest;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {

    public AppUser map(HotelRequest request) {
        return AppUser.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .appRole(Role.HOTEL)
                .build();
    }
}
