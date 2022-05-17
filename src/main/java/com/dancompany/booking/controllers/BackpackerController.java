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
import javax.validation.constraints.Positive;

import static com.dancompany.booking.exceptions.ExceptionWrapper.wrap;
import static com.dancompany.booking.exceptions.ExceptionWrapper.wrapWithoutResult;

@RestController
@RequestMapping("/backpacker")
@RequiredArgsConstructor
public class BackpackerController {

    private final BackpackerService backpackerService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<?> createBackpacker(@Valid @RequestBody BackpackerRequest backpackerRequest) {
        return wrap(backpackerService::createBackpacker, backpackerRequest);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{backpackerId}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<Void> updateById(@Positive @PathVariable("backpackerId") Long id, @Valid @RequestBody BackpackerRequest backpackerRequest) {
        return wrapWithoutResult(backpackerService::updateById, id, backpackerRequest);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{backpackerId}",
            produces = { "application/json" }
    )
    public ResponseEntity<BackpackerResponse> getById(@Positive @PathVariable("backpackerId") Long id) {
        return wrap(backpackerService::getById, id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{backpackerId}",
            produces = { "application/json" }
    )
    public ResponseEntity<Void> deleteById(@Positive @PathVariable("backpackerId") Long id) {
        return wrapWithoutResult(backpackerService::deleteById, id);
    }

}
