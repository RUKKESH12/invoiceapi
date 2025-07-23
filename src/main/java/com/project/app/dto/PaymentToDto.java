package com.project.app.dto;

import com.project.app.entity.PaymentMethod;

public class PaymentToDto {
 public static PaymentDto convertPaymentDto(PaymentDto paymentDto) {
	 return PaymentDto.builder().id(paymentDto.getId())
	  		 .invoiceId(paymentDto.getInvoiceId())
			 .paymentDate(paymentDto.getPaymentDate())
			 .amount(paymentDto.getAmount())
			 .method(paymentDto.getMethod())
			 .reference(paymentDto.getReference()).build();
 }
}
