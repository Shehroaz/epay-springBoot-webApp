package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

public class BankAccountDomain {
    private String account;
    private String account_holder_name;
    private String account_holder_type;
    private String bank_name;
    private String country;
    private String currency;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public String getAccount_holder_type() {
        return account_holder_type;
    }

    public void setAccount_holder_type(String account_holder_type) {
        this.account_holder_type = account_holder_type;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
