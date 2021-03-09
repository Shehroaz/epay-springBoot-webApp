package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin_product")
public class AdminProduct implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "product_name")
    public String product_name;

    @Column(name = "product_price")
    public Long product_price;

    @Column(name = "product_quantity")
    public Long product_quantity;

    @Column(name = "product_description")
    public String product_description;

    @Column(name = "product_image")
    public String product_image;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
     public Customer customer_fk;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    public ProductCategory product_category_fk;

    //region Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(Long product_price) {
        this.product_price = product_price;
    }

    public void setProduct_quantity(Long product_quantity) {
        this.product_quantity = product_quantity;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public void setCustomer_fk(Customer customer_fk) {
        this.customer_fk = customer_fk;
    }

    public void setProduct_category_fk(ProductCategory product_category_fk) {
        this.product_category_fk = product_category_fk;
    }
    //endregion

    //region Getters
    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public Long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Long getProduct_price() {
        return product_price;
    }

    public Long getProduct_quantity() {
        return product_quantity;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public Customer getCustomer_fk() {
        return customer_fk;
    }

    public ProductCategory getProduct_category_fk() {
        return product_category_fk;
    }
    //endregion
}
