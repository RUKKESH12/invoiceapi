package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.entity.Invoice;
import com.project.app.entity.Payment;
import com.project.app.repository.InvoiceRepository;
import com.project.app.repository.PaymentRepository;

@Service
public class PaymentServiceImps implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Payment addPayment(Long invoiceId, Payment payment) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow();
        payment.setInvoice(invoice);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentsForInvoice(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId);
    }
}

