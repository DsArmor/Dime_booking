package com.dancompany.booking.model.dto.response;

import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

public class HotelResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("description")
    private String description;

    //  start id
    public HotelResponse id(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //  end id

    //  start email
    public HotelResponse email(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //  end email


    //  start name
    public HotelResponse name(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //  end name

    //  start phone
    public HotelResponse phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //  end phone

    //  start description
    public HotelResponse description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //  end description

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HotelResponse hotelResponse = (HotelResponse) o;
        return Objects.equals(this.email, hotelResponse.email) &&
                Objects.equals(this.name, hotelResponse.name) &&
                Objects.equals(this.phone, hotelResponse.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HotelResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

