package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.PaymentRequestDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.PaymentRequestService;
import com.sherry.epaydigital.data.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/paymentRequest")
public class PaymentRequestController {
    private CustomerService customerService;
    private PaymentRequestService paymentRequestService;


    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    public PaymentRequestController(CustomerService customerService, PaymentRequestService paymentRequestService) {
        this.customerService = customerService;
        this.paymentRequestService = paymentRequestService;
    }
    @GetMapping
    public ModelAndView paymentRequestPageDisplay(Model model , HttpSession session){
        if ((session.getAttribute("isLoggedIn")) != null){
            ModelAndView modelAndView = new ModelAndView("/pages/sendAndRequest/paymentRequest");
            model.addAttribute("paymentRequestDomain" , new PaymentRequestDomain());
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
        }

        @PostMapping
    public ModelAndView addPaymentAndRequest(@ModelAttribute("paymentRequestDomain") PaymentRequestDomain paymentRequestDomain,
                                             HttpSession session){
            Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
            paymentRequestDomain.setCustomer(customer);

            String emailTo = paymentRequestDomain.getBuyer_email();
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("epaydigital20@gmail.com");
            simpleMailMessage.setTo(emailTo);
            String subject = "Payment Request";
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText("Click on this link to give payment : "
              +" http://localhost:8199/paymentRequest/requestPaymentPage");
            mailSender.send(simpleMailMessage);
            paymentRequestService.addPaymentRequestData(paymentRequestDomain);
            return new ModelAndView("/pages/sendAndRequest/successfullySent");
        }

    @GetMapping("/requestPaymentPage")
    public ModelAndView showPaymentPage(){
        return new ModelAndView("/pages/sendAndRequest/requestPaymentPage");

    }


}
