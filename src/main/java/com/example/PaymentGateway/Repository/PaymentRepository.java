package com.example.PaymentGateway.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentGateway.Model.Payment;

public interface PaymentRepository extends JpaRepository <Payment,Integer> {
    
    List<Payment> findByUserId(Long userId);
}
