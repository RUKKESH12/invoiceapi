package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.entity.InvoiceItem;
import com.project.app.service.InvoiceItemService;

@RestController
@RequestMapping("/api/invoices/{invoiceId}/items")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemService itemService;

    @PostMapping
    public ResponseEntity<InvoiceItem> addItem(@PathVariable Long invoiceId, @RequestBody InvoiceItem item) {
        return ResponseEntity.ok(itemService.addItemToInvoice(invoiceId, item));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItem>> getItems(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(itemService.getItemsByInvoiceId(invoiceId));
    }
}
 