package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.QRCodeDomain;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.EpayDigitalMeLink;
import com.sherry.epaydigital.data.model.QRCode;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import com.sherry.epaydigital.data.repository.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QRCodeService {
    private QRCodeRepository qrCodeRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public QRCodeService(QRCodeRepository qrCodeRepository, CustomerRepository customerRepository) {
        this.qrCodeRepository = qrCodeRepository;
        this.customerRepository = customerRepository;
    }


    public void addQRCodeToDb(QRCodeDomain qrCodeDomain, Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            if (customer.getQrCode() == null) {
                QRCode qrCode = new QRCode();
                qrCode.setQrCodeImage(qrCodeDomain.getQrCodeImage());
                qrCode.setCustomer(customer);
                customer.setQrCode(qrCode);
                qrCodeRepository.save(qrCode);
            }
        }
    }

    public String getQRImage(long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            long qrCodeId = customer.getQrCode().getId();
            Optional<QRCode> optionalQRCode = qrCodeRepository.findById(qrCodeId);
            if (optionalQRCode.isPresent()) {
                QRCode qrCode = optionalQRCode.get();
                return qrCode.getQrCodeImage();
            }
        }
        return null;
    }
}


