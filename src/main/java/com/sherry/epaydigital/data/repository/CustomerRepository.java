package com.sherry.epaydigital.data.repository;

import com.sherry.epaydigital.data.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
