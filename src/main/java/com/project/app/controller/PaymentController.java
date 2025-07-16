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

import com.project.app.entity.Payment;
import com.project.app.service.PaymentService;

@RestController
@RequestMapping("/api/invoices/{invoiceId}/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> addPayment(@PathVariable Long invoiceId, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.addPayment(invoiceId, payment));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(paymentService.getPaymentsForInvoice(invoiceId));
    }
}
