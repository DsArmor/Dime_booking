package com.dancompany.booking.service.implementation;

import com.dancompany.booking.exceptions.BadRequestException;
import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.dto.request.BookingRequest;
import com.dancompany.booking.model.dto.response.BookingResponse;
import com.dancompany.booking.model.dto.response.BookingResponseForBackpacker;
import com.dancompany.booking.model.dto.response.BookingResponseForHotel;
import com.dancompany.booking.model.dto.response.TimeResponse;
import com.dancompany.booking.model.mapper.BookingMapper;
import com.dancompany.booking.repository.BackpackerRepository;
import com.dancompany.booking.repository.BookingRepository;
import com.dancompany.booking.repository.RoomRepository;
import com.dancompany.booking.service.BookingService;
import com.dancompany.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BackpackerRepository backpackerRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    private final RoomService roomService;

    @Override
    public Long createBooking(Long backpackerId, Long roomId, BookingRequest bookingRequest) {
        validDate(bookingRequest.getStartBookingDateTime().toLocalDateTime(),
                bookingRequest.getEndBookingDateTime().toLocalDateTime(),
                roomRepository.getById(roomId).getStartAllocationDateTime(),
                roomRepository.getById(roomId).getEndAllocationDateTime());
        checkAllocate(bookingRequest.getStartBookingDateTime().toLocalDateTime(),
                bookingRequest.getEndBookingDateTime().toLocalDateTime(),
                roomId);
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
        validDate(bookingRequest.getStartBookingDateTime().toLocalDateTime(),
                bookingRequest.getEndBookingDateTime().toLocalDateTime(),
                oldBooking.getRoom().getStartAllocationDateTime(),
                oldBooking.getRoom().getEndAllocationDateTime());
        checkAllocate(bookingRequest.getStartBookingDateTime().toLocalDateTime(),
                bookingRequest.getEndBookingDateTime().toLocalDateTime(),
                oldBooking.getRoom().getId());
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

    private void validDate(LocalDateTime beginRest, LocalDateTime endRest,
                           LocalDateTime startRoom, LocalDateTime endRoom) {
        if (beginRest.isAfter(endRest)) {
            throw new BadRequestException("The start time cannot be later than the end time");
        }
        if (beginRest.isAfter(endRoom) || endRest.isAfter(endRoom) ||
                beginRest.isBefore(startRoom) || endRoom.isBefore(startRoom))
            throw new BadRequestException("The start time cannot be later than the end time");
    }

    private void checkAllocate(LocalDateTime beginRest, LocalDateTime endRest, Long roomId) {
        List<TimeResponse> timeResponses = roomService.getFreeTimeIntervalsById(roomId);
        for (TimeResponse timeResponse : timeResponses) {
            if (beginRest.isAfter(timeResponse.getStartBookingDateTime().toLocalDateTime()) &&
                    beginRest.isBefore(timeResponse.getStartBookingDateTime().toLocalDateTime()
                            .plusDays(timeResponse.getDuration()))) {
                throw new BadRequestException("Illegal allocate Time");
            } else if (endRest.isAfter(timeResponse.getStartBookingDateTime().toLocalDateTime()) &&
                    endRest.isBefore(timeResponse.getStartBookingDateTime().toLocalDateTime()
                            .plusDays(timeResponse.getDuration()))) {
                throw new BadRequestException("Illegal allocate Time");
            }
        }
    }
}
