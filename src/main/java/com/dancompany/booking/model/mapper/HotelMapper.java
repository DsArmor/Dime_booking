package com.dancompany.booking.model.mapper;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel map(AppUser user, HotelRequest hotelRequest) {
        return Hotel.builder()
                .appUser(user)
                .name(hotelRequest.getName())
                .description(hotelRequest.getDescription())
                .phone(hotelRequest.getPhone())
                .build();
    }

    public HotelResponse map(Hotel hotel) {
        return new HotelResponse()
                .id(hotel.getId())
                .email(hotel.getAppUser().getEmail())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .phone(hotel.getPhone());
    }
}
