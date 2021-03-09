package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.CardDomain;
import com.sherry.epaydigital.data.model.Card;
import com.sherry.epaydigital.data.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void addcard(CardDomain cardDomain){
        Card card = new Card();
        card.card_number = cardDomain.getCardnumber();
        card.exp_month = cardDomain.getExpMonth();
        card.exp_year = cardDomain.getExpYear();
        card.billing_address = cardDomain.getBillingAddress();
        card.security_code = cardDomain.getSecurityCode();
        card.customer_fk = cardDomain.getCustomer();
        cardRepository.save(card);
    }
}
