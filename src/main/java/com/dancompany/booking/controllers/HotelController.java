package com.dancompany.booking.controllers;

import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import com.dancompany.booking.model.dto.response.BookingResponseForHotel;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.BookingService;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import java.util.List;

import static com.dancompany.booking.exceptions.ExceptionWrapper.wrap;
import static com.dancompany.booking.exceptions.ExceptionWrapper.wrapWithoutResult;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final RoomService roomService;
    private final BookingService bookingService;

    /* Hotel Rest methods */

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{hotelId}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> updateById(@Positive @PathVariable("hotelId") Long id, @Valid @RequestBody HotelRequest hotelRequest) {
        return wrapWithoutResult(hotelService::updateById, id, hotelRequest);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{hotelId}",
            produces = {"application/json"}
    )
    public ResponseEntity<HotelResponse> getById(@Positive @PathVariable("hotelId") Long id) {
        return wrap(hotelService::getById, id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{hotelId}",
            produces = {"application/json"}
    )
    public ResponseEntity<Void> deleteById(@Positive @PathVariable("hotelId") Long id) {
        return wrapWithoutResult(hotelService::deleteById, id);
    }

    /* Hotel-Room Rest methods */

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/{hotelId}/room",
            produces = {"application/json"}
    )
    public ResponseEntity<Object> createRoom(
            @Positive @PathVariable("hotelId") Long id,
            @RequestBody RoomRequest roomRequest) {
        return wrap(roomService::createRoom, id, roomRequest);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{hotelId}/room/{roomId}",
            produces = {"application/json"}
    )
    public ResponseEntity<Void> updateRoom(
            @Positive @PathVariable("hotelId") Long hotelId,
            @Positive @PathVariable("roomId") Long roomId,
            @RequestBody RoomRequest roomRequest) {
        return wrapWithoutResult(roomService::updateById, hotelId, roomId, roomRequest);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{hotelId}/room/{roomId}",
            produces = {"application/json"}
    )
    public ResponseEntity<Void> deleteRoom(@Positive @PathVariable("hotelId") Long hotelId, @Positive @PathVariable("roomId") Long roomId) {
        return wrapWithoutResult(roomService::deleteById, hotelId, roomId);
    }

    /* Hotel-Room-Booking rest methods */

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{hotelId}/room/{roomId}/booking",
            produces = {"application/json"}
    )
    public ResponseEntity<List<BookingResponseForHotel>> getByRoomId(
            @Positive @PathVariable("hotelId") Long hotelId,
            @Positive @PathVariable("roomId") Long roomId) {
        return wrap(bookingService::getByRoomId, roomId);
    }
}
