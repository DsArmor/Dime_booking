package com.dancompany.booking.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.List;

public class BookingResponseForHotel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("backpacker")
    private BackpackerResponse backpackerResponse;

    @JsonProperty("startBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startBookingDateTime;

    @JsonProperty("endBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endBookingDateTime;

    public BookingResponseForHotel id(Long id) {
        this.id = id;
        return this;
    }

    public BookingResponseForHotel backpackerResponse(BackpackerResponse backpackerResponse) {
        this.backpackerResponse = backpackerResponse;
        return this;
    }

    public BookingResponseForHotel startBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
        return this;
    }

    public BookingResponseForHotel endBookingDateTime(OffsetDateTime endBookingDateTime) {
        this.endBookingDateTime = endBookingDateTime;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getStartBookingDateTime() {
        return startBookingDateTime;
    }

    public void setStartBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
    }

    public OffsetDateTime getEndBookingDateTime() {
        return endBookingDateTime;
    }

    public void setEndBookingDateTime(OffsetDateTime endBookingDateTime) {
        this.endBookingDateTime = endBookingDateTime;
    }

    public BackpackerResponse getBackpackerResponse() {
        return backpackerResponse;
    }

    public void setBackpackerResponse(BackpackerResponse backpackerResponse) {
        this.backpackerResponse = backpackerResponse;
    }
}

