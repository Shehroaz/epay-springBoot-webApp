package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.AddCategoryDomain;
import com.sherry.epaydigital.bussiness.domain.AddProductDomain;
import com.sherry.epaydigital.bussiness.domain.ProductCategoriesListDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.MyWebsiteAdminService;
import com.sherry.epaydigital.data.model.Customer;
import com.sherry.epaydigital.data.model.ProductCategory;
import com.sherry.epaydigital.utils.uploader.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Controller
public class MyWebsiteAdminController {
    private MyWebsiteAdminService myWebsiteAdminService;
    private CustomerService customerService;

    @Autowired
    public MyWebsiteAdminController(MyWebsiteAdminService myWebsiteAdminService, CustomerService customerService) {
        this.myWebsiteAdminService = myWebsiteAdminService;
        this.customerService = customerService;
    }

    @GetMapping("adminPanel")
    public String adminPanel(HttpSession session){
        if (session.getAttribute("isLoggedIn") != null)
             return "pages/myWebsite/admin/adminPanel";
        else
            return "redirect:/login";
    }




    @GetMapping("adminPanel/registeredWebsiteCustomers")
    public String registeredWebsiteCustomer(){
        return "pages/myWebsite/admin/adminPanel/registeredWebsiteCustomers";
    }


    @GetMapping("adminPanel/updateProducts")
    public String updateProducts(){
        return "pages/myWebsite/admin/adminPanel/updateProducts";
    }


}

