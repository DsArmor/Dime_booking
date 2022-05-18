package com.dancompany.booking.service.implementation;

import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.dto.request.BookingRequest;
import com.dancompany.booking.model.dto.response.BookingResponse;
import com.dancompany.booking.model.dto.response.BookingResponseForBackpacker;
import com.dancompany.booking.model.dto.response.BookingResponseForHotel;
import com.dancompany.booking.model.mapper.BookingMapper;
import com.dancompany.booking.repository.BackpackerRepository;
import com.dancompany.booking.repository.BookingRepository;
import com.dancompany.booking.repository.RoomRepository;
import com.dancompany.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BackpackerRepository backpackerRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Override
    public Long createBooking(Long backpackerId, Long roomId, BookingRequest bookingRequest) {
        Booking booking = bookingMapper.map(
                backpackerRepository.getById(backpackerId),
                roomRepository.getById(roomId),
                bookingRequest);
        bookingRepository.save(booking);
        return booking.getId();
    }

    @Override
    public void updateBooking(Long id, BookingRequest bookingRequest) {
        Booking oldBooking = bookingRepository.getById(id);
        Booking booking = bookingMapper.map(
                oldBooking.getBackpacker(),
                oldBooking.getRoom(),
                bookingRequest);
        booking.setId(id);
        bookingRepository.save(booking);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingResponseForHotel> getByRoomId(Long id) {
        return bookingRepository.findByRoomId(id)
                .stream()
                .map(bookingMapper::mapForHotel)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseForBackpacker> getByBackpackerId(Long id) {
        return bookingRepository.findByBackpackerId(id)
                .stream()
                .map(bookingMapper::mapForBackpacker)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponse> getByBackpackerIdAndRoomId(Long backpackerId, Long roomId) {
        return bookingRepository.findByBackpackerIdAndRoomId(backpackerId, roomId)
                .stream()
                .map(bookingMapper::map)
                .collect(Collectors.toList());
    }
}
