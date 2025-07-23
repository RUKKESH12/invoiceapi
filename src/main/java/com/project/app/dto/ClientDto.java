package com.project.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {
	private Long id;
    private String clientname;
    private String email;
    private String phoneNumber;
}
