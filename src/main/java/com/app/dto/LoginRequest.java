package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @JsonProperty("user_name")
    @NotBlank
    @Min(6)
    private String userName;

    @NotBlank
    @Min(6)
    private String password;
}
