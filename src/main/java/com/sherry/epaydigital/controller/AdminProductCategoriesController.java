package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.AddCategoryDomain;
import com.sherry.epaydigital.bussiness.service.AdminProductCategoriesService;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.data.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminProductCategoriesController {
    private AdminProductCategoriesService adminCategoriesService;
    private CustomerService customerService;

    @Autowired
    public AdminProductCategoriesController(AdminProductCategoriesService adminCategoriesService, CustomerService customerService) {
        this.adminCategoriesService = adminCategoriesService;
        this.customerService = customerService;
    }

    @GetMapping("productCategory/add")
    public ModelAndView addCategory(Model model , HttpSession session){
        if (session.getAttribute("isLoggedIn") != null) {
            ModelAndView modelAndView = new ModelAndView("pages/myWebsite/admin/adminPanel/addCategory");
            model.addAttribute("addCategory", new AddCategoryDomain());
            Set<String> allProductCategoriesList = adminCategoriesService.getAllProductCategories();
            model.addAttribute("categoriesList", allProductCategoriesList);
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping("productCategory/success")
    public String successAddCategory(@ModelAttribute("addCategory") AddCategoryDomain addCategoryDomain ,
                                     RedirectAttributes redirectAttributes, HttpSession session){
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        adminCategoriesService.addProductCategory(addCategoryDomain , customer.getId());
        redirectAttributes.addFlashAttribute("successCategoryMsg" , "Category for product is added successfully");
        return "redirect:/admin/productCategory/add";
    }
}
