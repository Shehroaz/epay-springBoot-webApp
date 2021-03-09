package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.InvoiceDomain;
import com.sherry.epaydigital.data.model.Invoice;
import com.sherry.epaydigital.data.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoiceDataToDb(InvoiceDomain invoiceDomain){
        Invoice invoice = new Invoice();
        invoice.setInvoice_number(invoiceDomain.getInvoice_number());
        invoice.setInvoice_date(invoiceDomain.getInvoice_date());
        invoice.setDue_date(invoiceDomain.getDue_date());
        invoice.setBill_to(invoiceDomain.getBill_to());
        invoice.setDescription(invoiceDomain.getDescription());
        invoice.setQuantity(invoiceDomain.getQuantity());
        invoice.setItem_price(invoiceDomain.getItem_price());
        invoice.setTax_price(invoiceDomain.getTax_price());
        invoice.setDiscount(invoiceDomain.getDiscount());
        invoice.setTotal_price(invoiceDomain.getTotal_price());
        invoice.setNote(invoiceDomain.getNote());
        invoice.setCustomer_fk(invoiceDomain.getCustomer());
        invoiceRepository.save(invoice);
    }
}
