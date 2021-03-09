package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.ProductCategory;

import java.util.List;

public class AddProductDomain {
    private String product_name;
    private Long product_price;
    private Long quantity;
    private String product_description;
    private String image;
    private Customer customer;
    private String productCategoryName;
    private ProductCategory productCategory;

    //region Setters
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(Long product_price) {
        this.product_price = product_price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    //endregion

    //region Getters
    public String getProduct_name() {
        return product_name;
    }

    public Long getProduct_price() {
        return product_price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getImage() {
        return image;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
    //endregion
}
