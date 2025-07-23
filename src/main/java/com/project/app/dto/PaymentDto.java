package com.project.app.dto;

import java.time.LocalDateTime;

import com.project.app.entity.PaymentMethod;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentDto {
	private Long id;
    private Long invoiceId;
    private LocalDateTime paymentDate;
    private Double amount;
    private PaymentMethod method;
    private String reference;
}
