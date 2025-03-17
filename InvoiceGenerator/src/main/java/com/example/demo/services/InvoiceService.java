package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Invoice;
import com.example.demo.repository.InvoiceRepo;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public void addInvoice(Invoice invoice) {
        invoiceRepo.save(invoice);
    }
}