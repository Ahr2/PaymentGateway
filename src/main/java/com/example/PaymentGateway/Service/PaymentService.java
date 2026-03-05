package com.example.PaymentGateway.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.PaymentGateway.Model.Payment;
import com.example.PaymentGateway.Repository.PaymentRepository;

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
}
