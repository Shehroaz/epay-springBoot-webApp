package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

public class PaymentRequestDomain {
    private String buyer_email;
    private Customer customer;

    //region setters

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //endregion

    //region getters

    public String getBuyer_email() {
        return buyer_email;
    }

    public Customer getCustomer() {
        return customer;
    }

    //endregion
}
