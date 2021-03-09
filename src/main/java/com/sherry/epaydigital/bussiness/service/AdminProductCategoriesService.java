package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.AddCategoryDomain;
import com.sherry.epaydigital.bussiness.domain.ProductCategoriesListDomain;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.ProductCategory;
import com.sherry.epaydigital.data.repository.AdminProductRepository;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import com.sherry.epaydigital.data.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminProductCategoriesService {
    private final ProductCategoryRepository productCategoryRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AdminProductCategoriesService(ProductCategoryRepository productCategoryRepository, CustomerRepository customerRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.customerRepository = customerRepository;
    }

    public void addProductCategory(AddCategoryDomain addCategoryDomain , Long customerId){
        Iterable<ProductCategory> productCategoryIterable =  productCategoryRepository.findAll();
        ProductCategory productCategory = null;
        boolean categoryExist = false;
        for (ProductCategory temp : productCategoryIterable){
            if (addCategoryDomain.getProduct_category().equals(temp.getProduct_category())) {
                categoryExist = true;
                productCategory = temp;
                break;
            }
        }
        if(productCategory == null)
            productCategory = new ProductCategory();

        if (!categoryExist) {
            productCategory.setProduct_category(addCategoryDomain.getProduct_category());
            addCategoryInDB(productCategory , customerId);
        }else{
            addCategoryInDB(productCategory , customerId);
        }
    }



    private void addCategoryInDB(ProductCategory productCategory , Long customerId){
        Optional<Customer> loginCustomer = customerRepository.findById(customerId);
        if (loginCustomer.isPresent()) {
            Customer customer = loginCustomer.get();
            productCategory.addCustomer(customer);
        }
        productCategoryRepository.save(productCategory);
    }

    public ProductCategoriesListDomain getProductsCategoryList(Long customerId) {
        ProductCategoriesListDomain productCategoriesListDomain = new ProductCategoriesListDomain();
        Set<String> set = new HashSet<>();
        Optional<Customer> loginCustomer = customerRepository.findById(customerId);
        if (loginCustomer.isPresent()) {
            Customer customer = loginCustomer.get();
            Set<ProductCategory> productCategoriesSet = customer.getCategories();
            for (ProductCategory productCategory : productCategoriesSet) {
                set.add(productCategory.getProduct_category());
            }
            productCategoriesListDomain.setProductCategoriesList(set);
            return productCategoriesListDomain;
        }
        return null;
    }

    public Set<String> getAllProductCategories(){
        Set<String> set = new HashSet<>();
        Iterable<ProductCategory> productCategories = productCategoryRepository.findAll();
        for (ProductCategory productCategory : productCategories) {
            set.add(productCategory.getProduct_category());
        }
        for(String n : set)
            System.out.println(n);
        return set;
    }
}
