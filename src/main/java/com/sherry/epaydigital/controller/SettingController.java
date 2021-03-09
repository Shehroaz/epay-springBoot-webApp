package com.sherry.epaydigital.controller;

import com.sherry.epaydigital.bussiness.domain.CustomerDomain;
import com.sherry.epaydigital.bussiness.domain.ShowBanksDomain;
import com.sherry.epaydigital.bussiness.domain.ShowCardsDomain;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.SettingService;
import com.sherry.epaydigital.utils.uploader.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SettingController {

    CustomerService customerService;
    SettingService settingService;


    @Autowired
    public SettingController(CustomerService customerService, SettingService settingService) {
        this.customerService = customerService;
        this.settingService = settingService;
    }


    @GetMapping("setting")
    public ModelAndView showSettingPage(Model model , HttpSession session){
        ModelAndView settingModelAndView = new ModelAndView("pages/user/setting");
        CustomerDomain customerDomain = customerService.getCustomerDetail(session.getAttribute("email").toString());
        model.addAttribute("setting" , customerDomain);
        System.out.println(customerDomain.getImage() + "jdkjdkj");
        return settingModelAndView;
    }

    @PostMapping("updateSettingImage")
    public String updateSetting(@RequestParam("image") MultipartFile multipartFile , HttpSession session) throws IOException {
        String fileName = "image";
        String email = session.getAttribute("email").toString();
        long id = customerService.addImage(email , fileName);
        fileName += id;
        FileUploadUtil.saveFile("uploads/userPhotos" , fileName , multipartFile);
        System.out.println(fileName);
        return "redirect:/setting";

    }

    @GetMapping("setting/security")
    public String securitySetting(){
        return "pages/setting/security";
    }

    @GetMapping("setting/cards")
    public ModelAndView userCards(Model model , HttpSession session){
        long id = customerService.getCustomerId(session.getAttribute("email").toString());
        ShowCardsDomain showCardsDomain = settingService.getCardsDetails(session.getAttribute("email").toString() , id);
        model.addAttribute("showCards" , showCardsDomain);
        ModelAndView modelAndView = new ModelAndView("pages/setting/myCards");
        return modelAndView;

    }

    @GetMapping("setting/bankAccounts")
    public ModelAndView userBanks(Model model , HttpSession session){
        long id = customerService.getCustomerId(session.getAttribute("email").toString());
        ShowBanksDomain showBanksDomain = settingService.getBankDetails(session.getAttribute("email").toString(), id);
        model.addAttribute("showBanks" , showBanksDomain);
        ModelAndView modelAndView = new ModelAndView("pages/setting/myBanks");
        return modelAndView;
    }
}
