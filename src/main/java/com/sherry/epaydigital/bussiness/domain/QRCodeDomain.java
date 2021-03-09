package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

public class QRCodeDomain {
    private String qrCodeImage;
    private Customer customer;

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        if (qrCodeImage == null)
            this.qrCodeImage = null;
        else
            this.qrCodeImage = "images/QRCodeImages/" + qrCodeImage;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
