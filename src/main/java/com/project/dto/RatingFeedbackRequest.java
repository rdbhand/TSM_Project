package com.project.dto;

public class RatingFeedbackRequest {

    private Long subscription_id;
    private Integer rating;
    private String feedback_text;

    public Long getSubscription_id() {
        return this.subscription_id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getFeedback_text() {
        return feedback_text;
    }


    public void setSubscription_id(Long subscription_id) {
        this.subscription_id = subscription_id;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setFeedback_text(String feedback_text) {
        this.feedback_text = feedback_text;
    }

// Getters and Setters
}
