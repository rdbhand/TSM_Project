package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tiffin_cancellations")
public class TiffinCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cancellationId;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    private LocalDate date;
    private String reason;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
