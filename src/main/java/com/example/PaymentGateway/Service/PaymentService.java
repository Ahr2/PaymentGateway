package com.example.PaymentGateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.PaymentGateway.Model.Payment;
import com.example.PaymentGateway.Repository.PaymentRepository;

import org.springframework.cache.annotation.Cacheable;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String makepayment(Long userid, double totalAmount) {
       
        //create payment gateway
        Payment payment=new Payment();
        payment.setUserId(userid);
        payment.setTotalAmount(totalAmount);
        payment.setStatus("Success");
        payment.getStatus();

        paymentRepository.save(payment);

        return "Transaction successfull: "+totalAmount;
    }

    @Cacheable(value = "payment", key = "#userid")
    public List<Payment> getPaymentsByUser(Long userid) {
        System.out.println("Fetching from DB...");
    return paymentRepository.findByUserId(userid);
    }
    
}




