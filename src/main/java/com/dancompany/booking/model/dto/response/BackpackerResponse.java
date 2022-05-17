package com.dancompany.booking.model.dto.response;

import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BackpackerResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    //  start id
    public BackpackerResponse id(Long id) {
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
    public BackpackerResponse email(String email) {
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
    public BackpackerResponse name(String name) {
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
    public BackpackerResponse phone(String phone) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackpackerResponse backpackerResponse = (BackpackerResponse) o;
        return Objects.equals(this.email, backpackerResponse.email) &&
                Objects.equals(this.name, backpackerResponse.name) &&
                Objects.equals(this.phone, backpackerResponse.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserRequest {\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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