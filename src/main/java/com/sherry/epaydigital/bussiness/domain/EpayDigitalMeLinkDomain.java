package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

public class EpayDigitalMeLinkDomain {
    private String me_link;
    private Customer customer;

    public String getMe_link() {
        return me_link;
    }

    public void setMe_link(String me_link) {
        this.me_link = me_link;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
