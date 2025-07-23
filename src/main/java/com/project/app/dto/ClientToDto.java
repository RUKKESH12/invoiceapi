package com.project.app.dto;

import com.project.app.entity.Client;



public class ClientToDto {
	public static ClientDto converToUserDto(Client client)
	{
		return ClientDto.builder().id(client.getId()).clientname(client.getName()).phoneNumber(client.getPhoneNumber()).email(client.getEmail()).build();
	}
}

