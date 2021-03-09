package com.sherry.epaydigital.bussiness.domain;

import java.sql.PreparedStatement;
import java.util.List;

public class ShowCardsDomain {
    private String name;
    private List<String>cardNumber;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(List<String> cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
