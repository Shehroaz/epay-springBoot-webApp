package com.sherry.epaydigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SendAndRequestController {

    @GetMapping("/sendAndRequest")
    public ModelAndView sendAndRequestPageView(HttpSession session){
        if ((session.getAttribute("isLoggedIn")) != null){
            ModelAndView modelAndView = new ModelAndView("/pages/sendAndRequest/sendAndRequestMainPage");
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
    }



}
