package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_category")
    private String product_category;

    @OneToMany(mappedBy = "product_category_fk")
    private Set<AdminProduct> adminProducts;

//    @ManyToMany(mappedBy = "categories")
//    private Set<Customer> customerSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE,
                    CascadeType.DETACH , CascadeType.REFRESH})
    @JoinTable(
            name = "customer_categories",
            joinColumns ={@JoinColumn(name = "category_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")})
    private Set<Customer> customerSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public Set<AdminProduct> getAdminProducts() {
        return adminProducts;
    }

    public void setAdminProducts(Set<AdminProduct> adminProducts) {
        this.adminProducts = adminProducts;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public void addCustomer(Customer customer){
        if (customerSet == null){
            customerSet = new HashSet<>();
        }
        customerSet.add(customer);
    }







}
