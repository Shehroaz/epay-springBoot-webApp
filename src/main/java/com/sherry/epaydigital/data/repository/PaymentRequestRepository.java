package com.sherry.epaydigital.data.repository;

import com.sherry.epaydigital.data.model.PaymentRequest;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRequestRepository extends CrudRepository<PaymentRequest , Long> {

}
