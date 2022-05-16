package com.dancompany.booking.service;

import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {

    public Long createBooking(Booking booking);
    public Long updateByBackpackerIdAndRoomId(Long backpackerId, Long roomId);
    public Long deleteById(Long id);
    public List<BookingResponse> getByRoomId(Long id);
    public List<BookingResponse> getByBackpackerId(Long id);
    public List<BookingResponse> getByBackpackerIdAndRoomId(Long backpackerId, Long roomId);
}
