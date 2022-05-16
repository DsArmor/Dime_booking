package com.dancompany.booking.service;

import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.response.HotelResponse;

public interface HotelService {

    public Long createHotel(Hotel hotel);
    public Long updateById(Long id, Hotel hotel);
    public HotelResponse getById(Long id);
    public Long deleteById(Long id);

}
