package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings_feedback")
public class RatingFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    private Integer rating; // 1 to 5
    private String feedbackText;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
