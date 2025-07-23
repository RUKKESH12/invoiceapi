package com.project.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InvoiceItemDto {
   private long id;
   private String description;
   private Integer quantity;
   private double unitprice;
   private double total;
	
}

