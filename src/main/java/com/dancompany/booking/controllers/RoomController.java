package com.dancompany.booking.controllers;

import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.model.dto.response.RoomResponse;
import com.dancompany.booking.model.dto.response.TimeResponse;
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
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public ResponseEntity<List<RoomResponse>> getAllRoom() {
        return wrap(roomService::getAll);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{roomId}",
            produces = {"application/json"}
    )
    public ResponseEntity<RoomResponse> getRoomById(@Positive @PathVariable("roomId") Long id) {
        return wrap(roomService::getById, id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "hotel/{hotelId}",
            produces = {"application/json"}
    )
    public ResponseEntity<List<RoomResponse>> getByHotelId(@Positive @PathVariable("hotelId") Long id) {
        return wrap(roomService::getByHotelId, id);
    }

    //TODO: add getfreetime rest method
    @RequestMapping(
            method = RequestMethod.GET,
            value = "{roomId}/times",
            produces = {"application/json"}
    )
    public ResponseEntity<List<TimeResponse>> getTimes(@Positive @PathVariable("roomId") Long id) {
        return wrap(roomService::getFreeTimeIntervalsById, id);
    }
}
