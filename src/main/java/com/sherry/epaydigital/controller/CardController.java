package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.CardDomain;
import com.sherry.epaydigital.bussiness.service.CardService;
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

@Controller

@RequestMapping("/card")
public class CardController {

    CustomerService customerService;
    CardService cardService;

    @Autowired
    public CardController(CustomerService customerService, CardService cardService) {
        this.customerService = customerService;
        this.cardService = cardService;
    }
    @GetMapping
    public ModelAndView addCard(Model model, HttpSession session){
        if (session.getAttribute("isLoggedIn") != null){
            ModelAndView modelAndView = new ModelAndView("pages/card/addCard");
            model.addAttribute("cardDomain" , new CardDomain());
            return modelAndView;
        }
        else{
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping
    public String addCard(@ModelAttribute("cardDomain") CardDomain cardDomain, HttpSession session){
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        cardDomain.setCustomer(customer);
        cardService.addcard(cardDomain);
        return "redirect:card/success";
    }
    @GetMapping("/success")
    public String page(){
        return "success";
    }

}
