package com.project.app.dto;

import com.project.app.entity.Invoice;

public class InvoiceToDto {
	public static InvoiceDto converToUserDto(Invoice invoice) {
	return InvoiceDto.builder().invoiceNumber(invoice.getInvoiceNumber()).issueDate(invoice.getIssueDate()).dueDate(invoice.getDueDate()).status(invoice.getStatus()).totalAmount(invoice.getTotalAmount()).build();
	}
}
