package com.dancompany.booking.model.mapper;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.model.Backpacker;
import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class BackpackerMapper {

    public Backpacker map(AppUser user, BackpackerRequest request) {
        return Backpacker.builder()
                .appUser(user)
                .name(request.getName())
                .phone(request.getPhone())
                .build();
    }

    public BackpackerResponse map(Backpacker backpacker) {
        return new BackpackerResponse()
                .id(backpacker.getId())
                .email(backpacker.getAppUser().getEmail())
                .name(backpacker.getName())
                .phone(backpacker.getPhone());
    }
}
