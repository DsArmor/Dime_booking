package com.dancompany.booking.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
}
