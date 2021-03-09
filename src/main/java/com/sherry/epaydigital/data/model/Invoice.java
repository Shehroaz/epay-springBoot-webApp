package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;

@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;

    @Id
    @GeneratedValue
    private Long id;

    private String invoice_number;
    private String due_date;
    private String Invoice_date;
    private String bill_to;
    private String description;
    private String quantity;
    private Long tax_price;
    private Long item_price;
    private Integer discount;
    private Long total_price;
    private String note;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer_fk;

    //region Setters
    public void setId(Long id) {
        this.id = id;
    }

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

    public void setNote(String note) {
        this.note = note;
    }

    public void setInvoice_date(String invoice_date) {
        Invoice_date = invoice_date;
    }

    public void setCustomer_fk(Customer customer_fk) {
        this.customer_fk = customer_fk;
    }
    //endregion

    //region Getters
    public Long getId() {
        return id;
    }

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

    public String getInvoice_date() {
        return Invoice_date;
    }

    public Customer getCustomer_fk() {
        return customer_fk;
    }
    //endregion
}
