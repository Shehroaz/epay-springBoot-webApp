package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.BankAccountDomain;
import com.sherry.epaydigital.data.model.BankAccount;
import com.sherry.epaydigital.data.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private  final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void addBankAccount(BankAccountDomain bankAccountDomain){
        BankAccount bankAccount = new BankAccount();
        bankAccount.account = bankAccountDomain.getAccount();
        bankAccount.account_holder_name = bankAccountDomain.getAccount_holder_name();
        bankAccount.account_holder_type = bankAccountDomain.getAccount_holder_type();
        bankAccount.bank_name = bankAccountDomain.getBank_name();
        bankAccount.country = bankAccountDomain.getCountry();
        bankAccount.currency = bankAccountDomain.getCurrency();
        bankAccount.customer_fk = bankAccountDomain.getCustomer();
        bankAccountRepository.save(bankAccount);
    }
}
