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

    public Long getFeedbackId() {
        return feedbackId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public Integer getRating() {
        return rating;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters and Setters
}
