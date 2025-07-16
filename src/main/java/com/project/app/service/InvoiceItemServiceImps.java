package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.entity.Invoice;
import com.project.app.entity.InvoiceItem;
import com.project.app.repository.InvoiceItemRepository;
import com.project.app.repository.InvoiceRepository;

@Service
public class InvoiceItemServiceImps implements InvoiceItemService {

    @Autowired
    private InvoiceItemRepository itemRepo;

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Override
    public InvoiceItem addItemToInvoice(Long invoiceId, InvoiceItem item) {
        Invoice invoice = invoiceRepo.findById(invoiceId).orElseThrow();
        item.setInvoice(invoice);
        return itemRepo.save(item);
    }

    @Override
    public List<InvoiceItem> getItemsByInvoiceId(Long invoiceId) {
    	
    	return itemRepo.findByInvoiceId(invoiceId);
    }
}
