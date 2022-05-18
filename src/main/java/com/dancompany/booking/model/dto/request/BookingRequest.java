package com.dancompany.booking.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class BookingRequest {

    @JsonProperty("startBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startBookingDateTime;

    @JsonProperty("endBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endBookingDateTime;

    public BookingRequest startBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
        return this;
    }

    public BookingRequest endBookingDateTime(OffsetDateTime endBookingDateTime) {
        this.endBookingDateTime = endBookingDateTime;
        return this;
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
}
