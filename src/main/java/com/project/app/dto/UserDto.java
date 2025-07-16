package com.project.app.dto;

import com.project.app.entity.Role;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
	private Long id;
	private String username;
	private Role role;
	private String email;
	

	
}
