package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_request")
public class PaymentRequest  implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;

    @Id
    @GeneratedValue
    private Long id;

    private String buyer_email;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer_fk;

    //region Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public void setCustomer_fk(Customer customer_fk) {
        this.customer_fk = customer_fk;
    }

    //endregion

    //region Getters

    public Long getId() {
        return id;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public Customer getCustomer_fk() {
        return customer_fk;
    }

    //endregion
}
