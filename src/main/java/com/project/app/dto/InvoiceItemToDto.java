package com.project.app.dto;

import java.lang.module.ModuleDescriptor.Builder;

public class InvoiceItemToDto {
  public static InvoiceItemDto converTouserDto(InvoiceItemDto invoiItemDto)
  {
	return invoiItemDto.builder().id(invoiItemDto.getId())
			.description(invoiItemDto.getDescription())
			.quantity(invoiItemDto.getQuantity())
			.unitprice(invoiItemDto.getUnitprice())
			.total(invoiItemDto.getTotal()).build();
  }
}
