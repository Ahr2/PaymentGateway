package com.example.PaymentGateway.Model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_amount")
    private double totalAmount;

    private String status;
}