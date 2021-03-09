package com.sherry.epaydigital.bussiness.domain;

public class QRDetails {
    public String sellerName;
    private String BankName;
    private String accountNumber;
    private String country;

    //regionSetters

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //endregionSetters

    //regionGetters

    public String getSellerName() {
        return sellerName;
    }

    public String getBankName() {
        return BankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCountry() {
        return country;
    }

    //EndregionGetters
}
