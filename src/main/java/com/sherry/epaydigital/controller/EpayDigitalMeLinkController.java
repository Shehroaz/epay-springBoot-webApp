package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.EpayDigitalMeLinkDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.EpayDigitalMeLinkService;
import com.sherry.epaydigital.data.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class EpayDigitalMeLinkController {

    CustomerService customerService;
    EpayDigitalMeLinkService epayDigitalMeLinkService;

    @Autowired
    public EpayDigitalMeLinkController(CustomerService customerService,
                                       EpayDigitalMeLinkService epayDigitalMeLinkService) {
        this.customerService = customerService;
        this.epayDigitalMeLinkService = epayDigitalMeLinkService;
    }

    @GetMapping("/epaydigitalme")
    public ModelAndView showMeLinkPage(Model model , HttpSession session){
        if (session.getAttribute("email") != null){
            ModelAndView modelAndView = new ModelAndView("/pages/sendAndRequest/epayDigitalMeLink");
            EpayDigitalMeLinkDomain epayDigitalMeLinkDomain = new EpayDigitalMeLinkDomain();
            model.addAttribute("meLinkDomain" , epayDigitalMeLinkDomain);
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/successEpayMeLink")
    public String meLinkCreated(@ModelAttribute("meLinkDomain") EpayDigitalMeLinkDomain epayDigitalMeLinkDomain,
                                RedirectAttributes redirectAttributes , HttpSession session){
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        epayDigitalMeLinkDomain.setCustomer(customer);
        Long customerId = customerService.getCustomerId(session.getAttribute("email").toString());
        boolean result = epayDigitalMeLinkService.addLinkToDb(epayDigitalMeLinkDomain,customerId);
        if (result){
            redirectAttributes.addFlashAttribute("trueMsg" , "username added successfully");
            return "redirect:/epaydigitalme";
        }
            redirectAttributes.addFlashAttribute("falseMsg" , "This username is exist choose another name");
            return "redirect:/epaydigitalme";
    }

    /**
     * This method is for displaying the payment page when buyer click on meLink
     * @return meLinkPaymentPage
     */
    @GetMapping(path = "/epaydigitalme/{name}")
    public ModelAndView paymentPageForMeLink(){
        return new ModelAndView("/pages/sendAndRequest/requestPaymentPage");
    }
}
