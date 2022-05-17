package com.dancompany.booking.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BackpackerRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    //  start email
    public BackpackerRequest email(String email) {
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
    public BackpackerRequest password(String phone) {
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
    public BackpackerRequest name(String name) {
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
    public BackpackerRequest phone(String phone) {
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
        BackpackerRequest backpackerRequest = (BackpackerRequest) o;
        return Objects.equals(this.email, backpackerRequest.email) &&
                Objects.equals(this.password, backpackerRequest.password) &&
                Objects.equals(this.name, backpackerRequest.name) &&
                Objects.equals(this.phone, backpackerRequest.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name, phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserRequest {\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
