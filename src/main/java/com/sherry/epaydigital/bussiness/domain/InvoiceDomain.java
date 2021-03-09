package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;

import java.util.Date;

public class InvoiceDomain {
    private String invoice_number;
    private String invoice_date;
    private String due_date;
    private String bill_to;
    private String description;
    private String quantity;
    private Long tax_price;
    private Long item_price;
    private Integer discount;
    private Long total_price;
    private String note;
    private String termsAndConditions;


    private Customer customer;

    //regionSetters

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setBill_to(String bill_to) {
        this.bill_to = bill_to;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTax_price(Long tax_price) {
        this.tax_price = tax_price;
    }

    public void setItem_price(Long item_price) {
        this.item_price = item_price;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    //endregion

    //region Getters

    public String getInvoice_number() {
        return invoice_number;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getBill_to() {
        return bill_to;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public Long getTax_price() {
        return tax_price;
    }

    public Long getItem_price() {
        return item_price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public String getNote() {
        return note;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }


    public String getInvoice_date() {
        return invoice_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    //endregion
}
