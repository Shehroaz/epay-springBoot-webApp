package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.CustomerDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignupController {

    CustomerService customerService;

    @Autowired
    public SignupController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public  ModelAndView customerSignup(Model model){
        ModelAndView modelAndView = new ModelAndView("pages/authentication/signupCustomer");
        model.addAttribute("customerDomain" , new CustomerDomain());
        return modelAndView;
    }

    @PostMapping
    public String addCustomer(@ModelAttribute("customerDomain") CustomerDomain customerDomain, RedirectAttributes errorMsgs){
        if (customerDomain.getPassword().equals(customerDomain.getRePassword())) {
            boolean result = customerService.addCustomer(customerDomain);
            if (result)
                return "redirect:/login";
        }
        errorMsgs.addFlashAttribute("signupError" , "Your Email already exists");
          return "redirect:/signup";
      }
    }

