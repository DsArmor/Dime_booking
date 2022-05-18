package com.dancompany.booking.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class TimeResponse {

    @JsonProperty("startBookingDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startBookingDateTime;

    @JsonProperty("duration")
    private Long duration;

    public TimeResponse startBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
        return this;
    }

    public TimeResponse duration(Long duration) {
        this.duration = duration;
        return this;
    }

    public OffsetDateTime getStartBookingDateTime() {
        return startBookingDateTime;
    }

    public void setStartBookingDateTime(OffsetDateTime startBookingDateTime) {
        this.startBookingDateTime = startBookingDateTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
