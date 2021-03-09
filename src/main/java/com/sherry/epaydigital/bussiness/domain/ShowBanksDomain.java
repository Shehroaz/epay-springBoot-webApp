package com.sherry.epaydigital.bussiness.domain;

import java.util.List;

public class ShowBanksDomain {
    private String username;
    private List<String> bankDetails;
    private int count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(List<String> bankDetails) {
        this.bankDetails = bankDetails;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
