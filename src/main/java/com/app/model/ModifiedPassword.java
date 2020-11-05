package com.app.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ModifiedPassword {
	@NotBlank
	private String userName;
	@NotBlank
	private String oldPassword;
	@NotBlank
	private String newPassword;
	@NotBlank
	private String retypePassword;
}
