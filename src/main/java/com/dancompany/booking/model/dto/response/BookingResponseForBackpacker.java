package com.dancompany.booking.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.List;

public class BookingResponseForBackpacker {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("room")
    private RoomResponse roomResponse;

    @JsonProperty("startBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startBookingDateTime;

    @JsonProperty("endBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endBookingDateTime;

    public BookingResponseForBackpacker id(Long id) {
        this.id = id;
        return this;
    }

    public BookingResponseForBackpacker roomResponse(RoomResponse roomResponse) {
        this.roomResponse = roomResponse;
        return this;
    }

    public BookingResponseForBackpacker startBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
        return this;
    }

    public BookingResponseForBackpacker endBookingDateTime(OffsetDateTime endBookingDateTime) {
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

    public RoomResponse getRoomResponse() {
        return roomResponse;
    }

    public void setRoomResponse(RoomResponse roomResponse) {
        this.roomResponse = roomResponse;
    }
}
