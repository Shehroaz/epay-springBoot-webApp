package com.sherry.epaydigital.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PaymentGatewayController {

    @RequestMapping("/pay")
    public ModelAndView showPaymentGatewayPage(){
        return new ModelAndView("/pages/gateway/paymentPage");
    }

    @PostMapping("/createOrder")
    @ResponseBody
    public String createOrder(@RequestBody Map<String , Object> data) throws Exception{
        System.out.println("in create order function");
        System.out.println(data);
        int amt = Integer.parseInt(data.get("amount").toString());
        RazorpayClient client = new RazorpayClient("rzp_test_Qncr2klHRUuEHA" , "gnJ7WqWHpuwyQM5YyO5F9T6o");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount" , amt*100);
        jsonObject.put("currency" , "INR");
        jsonObject.put("receipt" , "txn_2345677");

        //creating new order
       Order order =client.Orders.create(jsonObject);
        System.out.println(order);

        //save data in your database



        return order.toString();
    }


}
