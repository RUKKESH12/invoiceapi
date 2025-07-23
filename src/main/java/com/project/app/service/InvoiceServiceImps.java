package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.entity.Client;
import com.project.app.entity.Invoice;
import com.project.app.repository.ClientRepository;
import com.project.app.repository.InvoiceRepository;

@Service
public class InvoiceServiceImps implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    
    

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Long clientId = invoice.getClient().getId(); // assuming client has only ID set
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        
        invoice.setClient(client);
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}

