package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.AddProductDomain;
import com.sherry.epaydigital.bussiness.domain.ProductCategoriesListDomain;
import com.sherry.epaydigital.bussiness.service.AdminProductCategoriesService;
import com.sherry.epaydigital.bussiness.service.AdminProductsService;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.utils.uploader.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {
    private AdminProductsService adminProductsService;
    private CustomerService customerService;
    private AdminProductCategoriesService adminProductCategoriesService;

    @Autowired
    public AdminProductsController(AdminProductsService adminProductsService, CustomerService customerService,
                      AdminProductCategoriesService adminProductCategoriesService) {
        this.adminProductsService = adminProductsService;
        this.customerService = customerService;
        this.adminProductCategoriesService = adminProductCategoriesService;
    }

    @GetMapping("product/add")
    public ModelAndView addProducts(Model model , HttpSession session){
        if (session.getAttribute("isLoggedIn") != null){
            ModelAndView modelAndView = new ModelAndView("pages/myWebsite/admin/adminPanel/addProduct/addProduct");
            model.addAttribute("addProductDomain" , new AddProductDomain());
            Long customerId = customerService.getCustomerId(session.getAttribute("email").toString());
            ProductCategoriesListDomain productCategoriesListDomain = adminProductCategoriesService.getProductsCategoryList(customerId);
            model.addAttribute("productCategoriesListDomain", productCategoriesListDomain);
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }


    @PostMapping("product/addSuccess")
    public ModelAndView successAddProduct(@ModelAttribute("addProductDomain") AddProductDomain addProductDomain,
                                          @RequestParam("prodImage") MultipartFile multipartFile ,
                                          HttpSession session , RedirectAttributes redirectAttributes) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        String imageName = getImageName(multipartFile.getOriginalFilename());
        addProductDomain.setImage(imageName);
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        System.out.println(customer.getId());
        System.out.println(customer.getFirst_name());
        addProductDomain.setCustomer(customer);
        adminProductsService.addProduct(addProductDomain);
        System.out.println(addProductDomain.getImage());
        FileUploadUtil.saveFile("uploads/userPhotos" , addProductDomain.getImage() , multipartFile);
        redirectAttributes.addFlashAttribute("successProductMsg" , "Product is added successfully");
        return new ModelAndView("redirect:/admin/product/add");
}


    @GetMapping("/products")
    public ModelAndView allAvailableProducts(Model model , HttpSession session){
        if (session.getAttribute("isLoggedIn") != null) {
            ModelAndView modelAndView = new ModelAndView( "pages/myWebsite/admin/adminPanel/allAvailableProducts");
            long customerId = customerService.getCustomerId(session.getAttribute("email").toString());
            List<String> list =  adminProductsService.getAllProducts(customerId);
            model.addAttribute("allProductsList" , list);
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/login");
        }
    }


    private String getImageName(String imageText){
        Instant instant1 = Instant.now();
        long timeStampMillis = instant1.toEpochMilli();
        String time = String.valueOf(timeStampMillis);
        return time + imageText;
    }

}
