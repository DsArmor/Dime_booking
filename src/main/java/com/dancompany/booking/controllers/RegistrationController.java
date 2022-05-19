package com.dancompany.booking.controllers;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.implementation.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.dancompany.booking.exceptions.ExceptionWrapper.wrap;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final HotelService hotelService;
    private final BackpackerService backpackerService;

    @RequestMapping(
            method = RequestMethod.POST,
            value =  "/hotel",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<?> createHotel(@Valid @RequestBody HotelRequest hotelRequest) {
        return wrap(hotelService::createHotel, hotelRequest);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/backpacker",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<?> createBackpacker(@Valid @RequestBody BackpackerRequest backpackerRequest) {
        return wrap(backpackerService::createBackpacker, backpackerRequest);
    }

}
