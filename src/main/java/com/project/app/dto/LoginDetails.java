package com.project.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginDetails {
	private String username;
	private String password;
}
