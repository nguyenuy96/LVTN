package com.app.dto;

import com.app.model.Contact;
import com.app.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonPropertyOrder({
        "userName", "contact", "role"
})
public class AccountDTO {
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("role_name")
    private Role role;
    private Contact contact;
}