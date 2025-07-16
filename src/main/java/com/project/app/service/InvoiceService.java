package com.project.app.service;

import java.util.List;

import com.project.app.entity.Invoice;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);
    Invoice getInvoiceById(Long id);
    List<Invoice> getAllInvoices();
    void deleteInvoice(Long id);
}

