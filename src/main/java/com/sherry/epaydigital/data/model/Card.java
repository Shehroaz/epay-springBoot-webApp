package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import javax.swing.text.DefaultEditorKit;
import java.io.Serializable;
import java.util.Currency;

@Entity
@Table(name = "card")
public class Card implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "exp_month")
    public String exp_month;

    @Column(name = "exp_year")
    public String exp_year;

    @Column(name = "security_code")
    public String security_code;

    @Column(name = "billing_address")
    public String billing_address;

    @Column(name = "card_number")
    public Long card_number;

//    @OneToOne(mappedBy = "card_fk")
//    public Customer customer;
////
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    public Customer customer_fk;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer customer_fk;

}
