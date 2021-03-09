package com.sherry.epaydigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class EpaydigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpaydigitalApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
