package com.project.app.service;

import java.util.List;

import com.project.app.entity.Payment;

public interface PaymentService {
    Payment addPayment(Long invoiceId, Payment payment);
    List<Payment> getPaymentsForInvoice(Long invoiceId);
}

