package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    private Double amountPaid;
    private LocalDateTime paymentDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(unique = true)
    private String transactionId;


    public enum PaymentMethod {
        CASH, CARD, UPI, NETBANKING
    }

    // Getters and Setters
}
