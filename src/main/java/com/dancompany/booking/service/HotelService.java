package com.dancompany.booking.service;

import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {

    public Long createHotel(HotelRequest hotelRequest);
    public void updateById(Long id, HotelRequest hotelRequest);
    public HotelResponse getById(Long id);
    public List<HotelResponse> getAll();
    public void deleteById(Long id);

}
