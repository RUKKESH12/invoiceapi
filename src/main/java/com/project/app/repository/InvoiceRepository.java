package com.project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>{

}
