package com.dancompany.booking.controllers;

import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.implementation.BackpackerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.dancompany.booking.exceptions.ExceptionWrapper.wrap;

@RestController
@RequestMapping("/backpacker")
@RequiredArgsConstructor
public class BackpackerController {

    private final BackpackerService backpackerService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = { "application/json" }
    )
    public ResponseEntity<?> createBackpacker(@Valid @RequestBody BackpackerRequest backpackerRequest) {
        return wrap(backpackerService::createBackpacker, backpackerRequest);
    }

//    public

}
