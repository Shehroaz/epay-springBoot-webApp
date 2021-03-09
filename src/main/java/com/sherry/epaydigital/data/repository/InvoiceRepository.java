package com.sherry.epaydigital.data.repository;

import com.sherry.epaydigital.data.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice , Long> {
}
