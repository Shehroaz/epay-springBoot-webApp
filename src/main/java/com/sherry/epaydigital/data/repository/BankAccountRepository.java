package com.sherry.epaydigital.data.repository;

import com.sherry.epaydigital.data.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
