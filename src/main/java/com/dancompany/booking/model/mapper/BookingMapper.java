package com.dancompany.booking.model.mapper;

import com.dancompany.booking.model.Backpacker;
import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.Room;
import com.dancompany.booking.model.dto.request.BookingRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import com.dancompany.booking.model.dto.response.BookingResponse;
import com.dancompany.booking.model.dto.response.BookingResponseForBackpacker;
import com.dancompany.booking.model.dto.response.BookingResponseForHotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookingMapper {

    private final BackpackerMapper backpackerMapper;
    private final RoomMapper roomMapper;
    private final static ZoneOffset zone = ZoneOffset.UTC;

    public Booking map(Backpacker backpacker, Room room, BookingRequest bookingRequest) {
        return Booking.builder()
                .startBookingDateTime(bookingRequest.getStartBookingDateTime().toLocalDateTime())
                .endBookingDateTime(bookingRequest.getEndBookingDateTime().toLocalDateTime())
                .backpacker(backpacker)
                .room(room)
                .build();
    }

    public BookingResponseForHotel mapForHotel(Booking booking) {
        return new BookingResponseForHotel()
                .id(booking.getId())
                .backpackerResponse(backpackerMapper.map(booking.getBackpacker()))
                .startBookingDateTime(booking.getStartBookingDateTime().atOffset(zone))
                .endBookingDateTime(booking.getEndBookingDateTime().atOffset(zone));
    }

    public BookingResponseForBackpacker mapForBackpacker(Booking booking) {
        return new BookingResponseForBackpacker()
                .id(booking.getId())
                .roomResponse(roomMapper.map(booking.getRoom()))
                .startBookingDateTime(booking.getStartBookingDateTime().atOffset(zone))
                .endBookingDateTime(booking.getEndBookingDateTime().atOffset(zone));
    }

    public BookingResponse map(Booking booking) {
        return new BookingResponse()
                .id(booking.getId())
                .startBookingDateTime(booking.getStartBookingDateTime().atOffset(zone))
                .endBookingDateTime(booking.getEndBookingDateTime().atOffset(zone));
    }
}
