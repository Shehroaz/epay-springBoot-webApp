package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.CustomerDomain;
import com.sherry.epaydigital.bussiness.domain.LoginDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.utils.uploader.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;

@Controller
@RequestMapping("/login")
public class LoginController {

    CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView customerLogin(Model model, HttpSession session){
        if ((session.getAttribute("isLoggedIn")) != null){
            ModelAndView successModelAndView = new ModelAndView("pages/main/menu");
            CustomerDomain customerDomain = customerService.getCustomerDetail(session.getAttribute("email").toString());
            model.addAttribute("currentCustomer" , customerDomain);
            return successModelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("pages/authentication/login");
        model.addAttribute("login" , new LoginDomain());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView verifyCustomer(@ModelAttribute("login") LoginDomain loginDomain , Model model,
                                       HttpServletRequest request, RedirectAttributes errorMsgs ){
        if (customerService.verifyCustomer(loginDomain.getEmail() , loginDomain.getPassword())){
            ModelAndView successModelAndView = new ModelAndView("pages/main/menu");
            CustomerDomain customerDomain = customerService.getCustomerDetail(loginDomain.getEmail());
            model.addAttribute("currentCustomer" , customerDomain);
            request.getSession().invalidate();
            String email  = loginDomain.getEmail();
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("isLoggedIn", true);
            return successModelAndView;
        }else{
            errorMsgs.addFlashAttribute("loginError" , "Credentials are Incorrect");
            return new ModelAndView("redirect:/login");
        }
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
