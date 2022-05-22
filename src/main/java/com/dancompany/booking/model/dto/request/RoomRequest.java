package com.dancompany.booking.model.dto.request;

import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.model.dto.response.RoomResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class RoomRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("priceForDay")
    private Long priceForDay;

    @JsonProperty("startAllocationDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startAllocationDateTime;

    @JsonProperty("endAllocationDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endAllocationDateTime;

    public RoomRequest name(String name) {
        this.name = name;
        return this;
    }

    public RoomRequest description(String description) {
        this.description = description;
        return this;
    }

    public RoomRequest priceForDay(Long priceForDay) {
        this.priceForDay = priceForDay;
        return this;
    }

    public RoomRequest startAllocationDateTime(LocalDateTime startAllocationDateTime) {
        this.startAllocationDateTime = startAllocationDateTime;
        return this;
    }

    public RoomRequest endAllocationDateTime(LocalDateTime endAllocationDateTime) {
        this.endAllocationDateTime = endAllocationDateTime;
        return this;
    }

    @NotNull @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull @Positive
    public Long getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Long priceForDay) {
        this.priceForDay = priceForDay;
    }

    @NotNull @Valid
    public LocalDateTime getStartAllocationDateTime() {
        return startAllocationDateTime;
    }

    public void setStartAllocationDateTime(LocalDateTime startAllocationDateTime) {
        this.startAllocationDateTime = startAllocationDateTime;
    }

    @NotNull @Valid
    public LocalDateTime getEndAllocationDateTime() {
        return endAllocationDateTime;
    }

    public void setEndAllocationDateTime(LocalDateTime endAllocationDateTime) {
        this.endAllocationDateTime = endAllocationDateTime;
    }
}

