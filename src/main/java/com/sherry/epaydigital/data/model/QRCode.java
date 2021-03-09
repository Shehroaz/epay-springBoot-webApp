package com.sherry.epaydigital.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QR_Code")
public class QRCode implements Serializable {
    private static final long serialVersionId = -3009157732242241606l;

    @Id
    @GeneratedValue
    private Long id;

    private String qrCodeImage;

    @OneToOne(mappedBy = "qrCode")
    private Customer customer;

    //regionSetters

    public void setId(Long id) {
        this.id = id;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //endregion

    //regionGetters

    public Long getId() {
        return id;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public Customer getCustomer() {
        return customer;
    }

    //endregion


}
