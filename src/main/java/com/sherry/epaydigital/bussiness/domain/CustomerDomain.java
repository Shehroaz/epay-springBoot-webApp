package com.sherry.epaydigital.bussiness.domain;

import com.sherry.epaydigital.data.model.Card;

import java.util.List;
import java.util.Set;

public class CustomerDomain {
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String re_password;
    private String city;
    private String country;
    private String address_line1;
    private String address_line2;
    private String postal_code;
    private String state;
    private String image;
    private String phone_number;
    private Set<Card> cardSet;


    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return re_password;
    }

    public void setRePassword(String rePassword) {
        this.re_password = rePassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return address_line1;
    }

    public void setAddressLine1(String addressLine1) {
        this.address_line1 = addressLine1;
    }

    public String getAddressLine2() {
        return address_line2;
    }

    public void setAddressLine2(String addressLine2) {
        this.address_line2 = addressLine2;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postalCode) {
        this.postal_code = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if (image == null)
            this.image = null;
        else
            this.image = "/uploads/userPhotos/" + image;

    }


    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }
}
