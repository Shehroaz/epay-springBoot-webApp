package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.AddCategoryDomain;
import com.sherry.epaydigital.bussiness.domain.AddProductDomain;
import com.sherry.epaydigital.bussiness.domain.ProductCategoriesListDomain;
import com.sherry.epaydigital.data.model.AdminProduct;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.ProductCategory;
import com.sherry.epaydigital.data.repository.AdminProductRepository;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import com.sherry.epaydigital.data.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MyWebsiteAdminService {
    private final AdminProductRepository adminProductRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public MyWebsiteAdminService(AdminProductRepository adminProductRepository , ProductCategoryRepository
                                 productCategoryRepository,
                                 CustomerRepository customerRepository) {
        this.adminProductRepository = adminProductRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.customerRepository = customerRepository;
    }





}
