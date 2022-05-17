package com.dancompany.booking.model.mapper;

import com.dancompany.booking.model.Backpacker;
import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class BackpackerMapper {

    public Backpacker map(BackpackerRequest request) {
        return Backpacker.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build();
    }

    public BackpackerResponse map(Backpacker backpacker) {
        return new BackpackerResponse()
                .id(backpacker.getId())
                .email(backpacker.getEmail())
                .name(backpacker.getName())
                .phone(backpacker.getPhone());
    }
}
