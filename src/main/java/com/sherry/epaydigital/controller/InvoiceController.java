package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.InvoiceDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.InvoiceService;
import com.sherry.epaydigital.data.model.Customer;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class InvoiceController {
    CustomerService customerService;
    InvoiceService invoiceService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    public InvoiceController(CustomerService customerService, InvoiceService invoiceService) {
        this.customerService = customerService;
        this.invoiceService = invoiceService;

    }

    @GetMapping("/createInvoice")
    public ModelAndView createInvoice(Model model , HttpSession session , HttpServletRequest request){
        if ((session.getAttribute("isLoggedIn")) != null){
            ModelAndView modelAndView = new ModelAndView("/pages/sendAndRequest/createInvoice");
            InvoiceDomain invoiceDomain = new InvoiceDomain();
            invoiceDomain.setInvoice_date(getDate());
            invoiceDomain.setInvoice_number(getInvoiceNumber());
            invoiceDomain.setTermsAndConditions(getTermsAndCondition());
            model.addAttribute("invoiceDomain" , invoiceDomain);

            String token = RandomString.make(45) + getInvoiceNumber();
            System.out.println(token);
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/invoiceCreated")
    public ModelAndView invoiceCreated(@ModelAttribute("invoiceDomain") InvoiceDomain invoiceDomain,
                                       HttpSession session ){
        Customer customer = customerService.getCustomer(session.getAttribute("email").toString());
        invoiceDomain.setCustomer(customer);
        String emailTo = invoiceDomain.getBill_to();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("epaydigital20@gmail.com");
        simpleMailMessage.setTo(emailTo);
        String subject = "Invoice";
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(" Invoice number : " + invoiceDomain.getInvoice_number()
        + "\n" + " Invoice date : " + invoiceDomain.getInvoice_date()
                +"\n" + " Due date : " + invoiceDomain.getDue_date()
                +"\n" + " Amount Due : " + invoiceDomain.getTotal_price()
                +"\n" + " Description  : " + invoiceDomain.getDescription()
                +"\n" + " Quantity  : " + invoiceDomain.getQuantity()
                +"\n" + " Product price  : " + invoiceDomain.getItem_price()
                +"\n" + " Discount  : " + invoiceDomain.getDiscount()
                +"\n" + " Total amount  : " + invoiceDomain.getTotal_price()
                +"\n" + "To confirm your account, please click here : "
                +"http://localhost:8199/paymentPage?amount="+invoiceDomain.getTotal_price()
                        +"\n" + " " +invoiceDomain.getNote()
        );
        javaMailSender.send(simpleMailMessage);
        invoiceService.addInvoiceDataToDb(invoiceDomain);
        return new ModelAndView("/pages/sendAndRequest/successfullySent");
    }
    @GetMapping("invoicePreview")
    public ModelAndView showPreview(){
        return new ModelAndView("/pages/sendAndRequest/previewInvoice");
    }

    @GetMapping("/paymentPage")
    public ModelAndView showPaymentPage(Model model ,  @RequestParam("amount") String totalPrice){
        System.out.println(totalPrice);
        model.addAttribute("totalAmount" , totalPrice);
        return new ModelAndView("/pages/sendAndRequest/paymentPage");
    }





    private String getDate(){
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return localDate.format(dateTimeFormatter);
    }

    private String getInvoiceNumber(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }
    private String getTermsAndCondition(){
        return "We are a web based / mobile payment service provider that allow buyer and" +
                "seller to transfer funds instantaneously while protecting against fraud and" +
                "identity theft.\n" +
                "@ epaydigital we designed an online payment gateway to facilitate easy" +
                "payments for merchants.";
    }




}
