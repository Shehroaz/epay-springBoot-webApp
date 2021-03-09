package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.CustomerDomain;
import com.sherry.epaydigital.bussiness.domain.QRDetails;
import com.sherry.epaydigital.data.model.BankAccount;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean addCustomer(CustomerDomain customerDomain) {
        Iterable<Customer> customerIterable = customerRepository.findAll();
        for (Customer cust : customerIterable) {
            if (cust.getEmail().equals(customerDomain.getEmail()))
                return false;
        }
        Customer customer = new Customer();
        customer.setFirst_name(customerDomain.getFirstName());
        customer.setLast_name(customerDomain.getLastName());
        customer.setEmail(customerDomain.getEmail());
        customer.setPassword(customerDomain.getPassword());
        customer.setCity(customerDomain.getCity());
        customer.setCountry(customerDomain.getCountry());
        customer.setAddress_line1(customerDomain.getAddressLine1());
        customer.setAddress_line2(customerDomain.getAddressLine2());
        customer.setPostal_code(customerDomain.getPostalCode());
        customer.setState(customerDomain.getState());
        customer.setPhone_number(customerDomain.getPhoneNumber());
        customerRepository.save(customer);
        return true;
    }

    public CustomerDomain getCustomerDetail(String email) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                CustomerDomain customerDomain = new CustomerDomain();
                customerDomain.setFirstName(customer.getFirst_name());
                customerDomain.setLastName(customer.getLast_name());
                customerDomain.setEmail(customer.getEmail());
                customerDomain.setPassword(customer.getPassword());
                customerDomain.setCity(customer.getCity());
                customerDomain.setCountry(customer.getCountry());
                customerDomain.setAddressLine1(customer.getAddress_line1());
                customerDomain.setAddressLine2(customer.getAddress_line2());
                customerDomain.setPostalCode(customer.getPostal_code());
                customerDomain.setState(customer.getState());
                customerDomain.setPhoneNumber(customer.getPhone_number());
                customerDomain.setImage(customer.getImage());
                return customerDomain;
            }
        }
        return null;
    }

    public boolean verifyCustomer(String email, String password) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String email) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public long addImage(String email, String image) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                customer.setImage(image + customer.getId());
                return customer.getId();
            }
        }
        return -1;
    }

    public long getCustomerId(String email) {
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers)
            if (customer.getEmail().equals(email))
                return customer.getId();

        return -9999;

    }

    public QRDetails getCustomerDetailsForQRCode(long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        QRDetails qrDetails = new QRDetails();
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            qrDetails.setSellerName(customer.getFirst_name());
            Set<BankAccount> accountNumbers = customer.getBankAccount();
            for (BankAccount bankAccount : accountNumbers) {
                qrDetails.setAccountNumber(bankAccount.account);
                qrDetails.setBankName(bankAccount.bank_name);
            }
            qrDetails.setCountry(customer.getCountry());
        }
        return qrDetails;
    }
}
