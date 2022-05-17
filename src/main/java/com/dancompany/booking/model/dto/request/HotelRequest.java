package com.dancompany.booking.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class HotelRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("description")
    private String description;

    //  start email
    public HotelRequest email(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //  end email

    //  start password
    public HotelRequest password(String phone) {
        this.phone = phone;
        return this;
    }

    @NotNull
    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //  end password


    //  start name
    public HotelRequest name(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //  end name

    //  start phone
    public HotelRequest phone(String phone) {
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
    public HotelRequest description(String description) {
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
        HotelRequest hotelRequest = (HotelRequest) o;
        return Objects.equals(this.email, hotelRequest.email) &&
                Objects.equals(this.password, hotelRequest.password) &&
                Objects.equals(this.name, hotelRequest.name) &&
                Objects.equals(this.phone, hotelRequest.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name, phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HotelRequest {\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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