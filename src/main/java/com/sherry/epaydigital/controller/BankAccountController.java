package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.BankAccountDomain;
import com.sherry.epaydigital.bussiness.service.BankAccountService;
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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/addBankAccount")
public class BankAccountController {

    private BankAccountService bankAccountService;
    private CustomerService customerService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService, CustomerService customerService) {
        this.bankAccountService = bankAccountService;
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView addBankAccount(Model model, HttpSession session){
        if(session.getAttribute("isLoggedIn") != null){
            ModelAndView modelAndView = new ModelAndView("pages/bank/addBankAccount");
            model.addAttribute("bankAccountDomain" , new BankAccountDomain());
            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }

    @PostMapping
    public String addBankAccount(@ModelAttribute("bankAccountDomain") BankAccountDomain bankAccountDomain,
                                 HttpSession session){
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        bankAccountDomain.setCustomer(customer);
        bankAccountService.addBankAccount(bankAccountDomain);
        return "redirect:/addBankAccount/successAddBankAccount";
    }

    @GetMapping("successAddBankAccount")
    public String success(){
        return "pages/bank/successBankAccount";
    }
}

