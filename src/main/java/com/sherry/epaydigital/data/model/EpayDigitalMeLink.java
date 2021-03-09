package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "epay_me_link")
public class EpayDigitalMeLink implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;

    @Id
    @GeneratedValue
    private Long id;

    private String me_link;

    @OneToOne(mappedBy = "epayDigitalMeLink")
    private Customer customer;

    //region Setters

    public void setMe_link(String me_link) {
        this.me_link = me_link;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //endregion

    //region Getters

    public String getMe_link() {
        return me_link;
    }

    public Customer getCustomer() {
        return customer;
    }

    //endregion

}
