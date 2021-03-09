package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.PaymentRequestDomain;
import com.sherry.epaydigital.data.model.PaymentRequest;
import com.sherry.epaydigital.data.repository.PaymentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestService {
    private final PaymentRequestRepository paymentRequestRepository;

    @Autowired
    public PaymentRequestService(PaymentRequestRepository paymentRequestRepository) {
        this.paymentRequestRepository = paymentRequestRepository;
    }

    public void addPaymentRequestData(PaymentRequestDomain paymentRequestDomain) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setBuyer_email(paymentRequestDomain.getBuyer_email());
        paymentRequest.setCustomer_fk(paymentRequestDomain.getCustomer());
        paymentRequestRepository.save(paymentRequest);
    }
}
