package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ContactReq {
    @NotBlank
    private String name;

    @NotBlank
    @JsonProperty("account_id")
    private Long accountId;

    private String gender;

    @NotBlank
    @JsonProperty("phone_number")
    private String phoneNumber;

    private String nationality;

    private String identification;

    private String address;
}
