package com.project.app.dto;

import com.project.app.entity.User;

public class UserToDto {

	public static UserDto converToUserDto(User user)
	{
		return UserDto.builder().id(user.getId()).username(user.getUsername()).role(user.getRole()).email(user.getEmail()).build();
	}
}
