package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "customer")
 public class Customer implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "address_Line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "state")
    private String state;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "customer_fk")
    private Set<Card> card;

    @OneToMany(mappedBy = "customer_fk")
    private Set<BankAccount> bankAccount;

    @OneToMany(mappedBy = "customer_fk")
    private Set<AdminProduct> adminProducts;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE,
                    CascadeType.DETACH , CascadeType.REFRESH})
    @JoinTable(
            name = "customer_categories",
            joinColumns ={@JoinColumn(name = "customer_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private Set<ProductCategory> categories;

    @OneToMany(mappedBy = "customer_fk")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "customer_fk")
    private Set<PaymentRequest> paymentRequests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "epay_me_link", referencedColumnName = "id")
    private EpayDigitalMeLink epayDigitalMeLink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qr_code", referencedColumnName = "id")
    private QRCode qrCode;

    //region Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCard(Set<Card> card) {
        this.card = card;
    }

    public void setBankAccount(Set<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setAdminProducts(Set<AdminProduct> adminProducts) {
        this.adminProducts = adminProducts;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setPaymentRequests(Set<PaymentRequest> paymentRequests) {
        this.paymentRequests = paymentRequests;
    }

    public void setEpayDigitalMeLink(EpayDigitalMeLink epayDigitalMeLink) {
        this.epayDigitalMeLink = epayDigitalMeLink;
    }

    public void setQrCode(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    //endregion

    //region Getters

    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getState() {
        return state;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getImage() {
        return image;
    }

    public Set<Card> getCard() {
        return card;
    }

    public Set<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public Set<AdminProduct> getAdminProducts() {
        return adminProducts;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public Set<PaymentRequest> getPaymentRequests() {
        return paymentRequests;
    }

    public EpayDigitalMeLink getEpayDigitalMeLink() {
        return epayDigitalMeLink;
    }

    public QRCode getQrCode() {
        return qrCode;
    }

    //endregion

    }



