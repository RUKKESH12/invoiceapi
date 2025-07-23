package com.project.app.dto;

import java.time.LocalDate;

import com.project.app.entity.Status;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class InvoiceDto {
	 
	    private String invoiceNumber;
	    private LocalDate issueDate;
	    private LocalDate dueDate;
	    private Status status; // DRAFT, SENT, PAID, CANCELLED
	    private Double totalAmount;
}
