package com.example.PaymentGateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentGateway.Model.Payment;
import com.example.PaymentGateway.Service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private  PaymentService paymentService;

    @PostMapping("/pay")
    public String pay(@RequestParam Long userid, @RequestParam double totalAmount){
        return paymentService.makepayment(userid,totalAmount);
    }


    @GetMapping("/payments")
        public List<Payment> getPayments(@RequestParam Long userid){
    return paymentService.getPaymentsByUser(userid);
    }
}