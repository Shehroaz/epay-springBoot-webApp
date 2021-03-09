package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String account;
    public String account_holder_name;
    public String account_holder_type;
    public String bank_name;
    public String country;
    public String currency;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer customer_fk;

}
