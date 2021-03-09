package com.sherry.epaydigital.bussiness.service;

import com.sherry.epaydigital.bussiness.domain.AddProductDomain;
import com.sherry.epaydigital.data.model.AdminProduct;
import com.sherry.epaydigital.data.model.ProductCategory;
import com.sherry.epaydigital.data.repository.AdminProductRepository;
import com.sherry.epaydigital.data.repository.CustomerRepository;
import com.sherry.epaydigital.data.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProductsService {
    private final AdminProductRepository adminProductRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public AdminProductsService(AdminProductRepository adminProductRepository , ProductCategoryRepository
            productCategoryRepository) {
        this.adminProductRepository = adminProductRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public void addProduct(AddProductDomain addProductDomain){
        AdminProduct adminProduct = new AdminProduct();
        adminProduct.setProduct_name(addProductDomain.getProduct_name());
        adminProduct.setProduct_description(addProductDomain.getProduct_description());
        adminProduct.setProduct_image(addProductDomain.getImage());
        adminProduct.setProduct_price(addProductDomain.getProduct_price());
        adminProduct.setProduct_quantity(addProductDomain.getQuantity());
        adminProduct.setCustomer_fk(addProductDomain.getCustomer());
        adminProduct.setProduct_category_fk(getProductCategory(addProductDomain.getProductCategoryName()));
        System.out.println(addProductDomain.getProductCategoryName());
        adminProductRepository.save(adminProduct);
    }


    public List<String> getAllProducts(long customerId){
        List<String> list = new ArrayList<>();
        Iterable<AdminProduct> allProducts = adminProductRepository.findAll();
        for(AdminProduct product : allProducts){
            if (product.getCustomer_fk().getId() == customerId){
                list.add("Product name is " +  product.getProduct_name() + " and quantity of " +
                        product.getProduct_name() + " is " + product.getProduct_quantity());
            }
        }
        return list;
    }
    private ProductCategory getProductCategory(String categoryName){
        Iterable<ProductCategory> productCategories = productCategoryRepository.findAll();
        for (ProductCategory productCategory : productCategories) {
            if (categoryName.equals(productCategory.getProduct_category())) {
                return productCategory;
            }
        }
        return null;
    }

}
