package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

public class CardDomain {
    private long id;
    private String exp_month;
    private String exp_year;
    private String security_code;
    private String billing_address;
    private Long card_number;
    private CustomerDomain customer_domain;
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpMonth() {
        return exp_month;
    }

    public void setExpMonth(String expMonth) {
        this.exp_month = expMonth;
    }

    public String getExpYear() {
        return exp_year;
    }

    public void setExpYear(String exp_year) {
        this.exp_year = exp_year;
    }

    public String getSecurityCode() {
        return security_code;
    }

    public void setSecurityCode(String security_code) {
        this.security_code = security_code;
    }

    public String getBillingAddress() {
        return billing_address;
    }

    public Long getCardnumber() {
        return card_number;
    }

    public void setCardnumber(long card_number) {
        this.card_number = card_number;
    }

    public void setBillingAddress(String billing_address) {

        this.billing_address = billing_address;
    }

    public CustomerDomain getCustomerDomain() {
        return customer_domain;
    }

    public void setCustomerDomain(CustomerDomain customer_domain) {
        this.customer_domain = customer_domain;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
