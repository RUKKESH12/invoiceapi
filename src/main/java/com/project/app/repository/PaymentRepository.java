package com.project.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findByInvoiceId(Long invoiceId);
}
