package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.ShowBanksDomain;
import com.sherry.epaydigital.bussiness.domain.ShowCardsDomain;
import com.sherry.epaydigital.data.model.BankAccount;
import com.sherry.epaydigital.data.model.Card;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.repository.BankAccountRepository;
import com.sherry.epaydigital.data.repository.CardRepository;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SettingService {
    private final CustomerRepository customerRepository;
    private final CardRepository cardRepository;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public SettingService(CustomerRepository customerRepository, CardRepository cardRepository, BankAccountRepository bankAccountRepository) {
        this.customerRepository = customerRepository;
        this.cardRepository = cardRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public ShowCardsDomain getCardsDetails(String email , long id) {
        ShowCardsDomain showCardsDomain = new ShowCardsDomain();
        Iterable<Card> cards = cardRepository.findAll();
        List<String> list = new ArrayList<>();
        int count = 0;
        for (Card card : cards) {
            if (id == card.customer_fk.getId()) {
                String cardNumber = String.valueOf(card.card_number);
                cardNumber = "************" + cardNumber.substring(12);
                System.out.println(cardNumber);
                list.add(cardNumber);
                count++;
            }
        }
        showCardsDomain.setCardNumber(list);
        showCardsDomain.setCount(count);
        showCardsDomain.setName(getUserName(email));
        return showCardsDomain;
    }

    private String getUserName(String email) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer.getFirst_name() + " " + customer.getLast_name();
            }
        }
        return null;
    }


    public ShowBanksDomain getBankDetails(String email , long id){
        ShowBanksDomain showBanksDomain = new ShowBanksDomain();
        Iterable<BankAccount> bankAccounts = bankAccountRepository.findAll();
        List<String> list = new ArrayList<>();
        int count = 0;
        for (BankAccount bankAccount : bankAccounts){
            if (id == bankAccount.customer_fk.getId()){
                String accountNumber = bankAccount.account;
                accountNumber = "************" + accountNumber.substring(12);
                list.add( count + 1 + ": Account Number is " + accountNumber + " Bank Name is " +
                        bankAccount.bank_name + " Account Type is " + bankAccount.account_holder_type);
                count++;
            }
        }

        showBanksDomain.setBankDetails(list);
        showBanksDomain.setUsername(getUserName(email));
        showBanksDomain.setCount(count);
        return showBanksDomain;
    }

}
