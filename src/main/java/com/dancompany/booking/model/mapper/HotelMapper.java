package com.dancompany.booking.model.mapper;

import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;

public class HotelMapper {

    public Hotel map(HotelRequest hotelRequest) {
        return Hotel.builder()
                .email(hotelRequest.getEmail())
                .password(hotelRequest.getPassword())
                .name(hotelRequest.getName())
                .description(hotelRequest.getDescription())
                .phone(hotelRequest.getPhone())
                .build();
    }

    public HotelResponse map(Hotel hotel) {
        return new HotelResponse()
                .id(hotel.getId())
                .email(hotel.getEmail())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .phone(hotel.getPhone());
    }
}
