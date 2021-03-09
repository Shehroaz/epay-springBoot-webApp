package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.ProductCategory;

public class AddCategoryDomain {
    private String product_category;
    private Customer customer;


    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
