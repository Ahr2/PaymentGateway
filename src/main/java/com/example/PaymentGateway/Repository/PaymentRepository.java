package com.example.PaymentGateway.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentGateway.Model.Payment;

public interface PaymentRepository extends JpaRepository <Payment,Integer> {
    
}
