package com.project.app.response;

import com.project.app.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class APIResponse<T> {
	
	String message;
	boolean status;
	T data;
}
