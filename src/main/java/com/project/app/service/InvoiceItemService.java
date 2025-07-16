package com.project.app.service;

import java.util.List;

import com.project.app.entity.InvoiceItem;

public interface InvoiceItemService {
    InvoiceItem addItemToInvoice(Long invoiceId, InvoiceItem item);
    List<InvoiceItem> getItemsByInvoiceId(Long invoiceId);
}
