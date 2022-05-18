package com.dancompany.booking.service;

import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.dto.request.BookingRequest;
import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.BookingResponse;
import com.dancompany.booking.model.dto.response.BookingResponseForBackpacker;
import com.dancompany.booking.model.dto.response.BookingResponseForHotel;

import java.util.List;

public interface BookingService {

    /* For Backpacker */
    public Long createBooking(Long backpackerId, Long roomId, BookingRequest bookingRequest);
    public void updateBooking(Long id, BookingRequest bookingRequest);
    public void deleteById(Long id);
    public List<BookingResponseForBackpacker> getByBackpackerId(Long id);
    public List<BookingResponse> getByRoomIdAndBackpackerId(Long roomId, Long backpackerId);
    /* For Hotel */
    public List<BookingResponseForHotel> getByRoomId(Long id); // не возвращать id клиента
}
