package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.EpayDigitalMeLinkDomain;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.EpayDigitalMeLink;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import com.sherry.epaydigital.data.repository.EpayDigitalMeLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EpayDigitalMeLinkService {
    private CustomerRepository customerRepository;
    private EpayDigitalMeLinkRepository epayDigitalMeLinkRepository;

    @Autowired
    public EpayDigitalMeLinkService(CustomerRepository customerRepository, EpayDigitalMeLinkRepository epayDigitalMeLinkRepository) {
        this.customerRepository = customerRepository;
        this.epayDigitalMeLinkRepository = epayDigitalMeLinkRepository;
    }

    public boolean addLinkToDb(EpayDigitalMeLinkDomain epayDigitalMeLinkDomain , Long customerId){
        Iterable<EpayDigitalMeLink> epayDigitalMeLinks =  epayDigitalMeLinkRepository.findAll();
        for (EpayDigitalMeLink epayDigitalMeLink : epayDigitalMeLinks)
            if (epayDigitalMeLink.getMe_link().equals(epayDigitalMeLinkDomain.getMe_link()))
                return false;
            EpayDigitalMeLink epayDigitalMeLink = new EpayDigitalMeLink();
            epayDigitalMeLink.setMe_link(epayDigitalMeLinkDomain.getMe_link());
        System.out.println(epayDigitalMeLinkDomain.getMe_link());


        Optional<Customer> customers = customerRepository.findById(customerId);
        if (customers.isPresent()){
            Customer customer = customers.get();
            customer.setEpayDigitalMeLink(epayDigitalMeLink);
            epayDigitalMeLink.setCustomer(customer);
        }
        epayDigitalMeLinkRepository.save(epayDigitalMeLink);
        return true;
     }
}
