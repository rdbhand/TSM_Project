package com.project.controllers;

import com.project.dto.RatingFeedbackRequest;
import com.project.model.RatingFeedback;
import com.project.model.Subscription;
import com.project.repository.SubscriptionRepository;
import com.project.service.RatingFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("*")
public class RatingFeedbackController {

    @Autowired
    private RatingFeedbackService service;

    @Autowired
    private SubscriptionRepository subscriptionRepo;


    @PostMapping("/save")
    public ResponseEntity<?> saveFeedback(@RequestBody RatingFeedbackRequest request) {

        if (request.getSubscription_id() == null) {
            return ResponseEntity.badRequest().body("Subscription ID cannot be null");
        }

        Subscription subscription = subscriptionRepo.findById(request.getSubscription_id())
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        RatingFeedback feedback = new RatingFeedback();
        feedback.setSubscription(subscription);
        feedback.setRating(request.getRating());
        feedback.setFeedbackText(request.getFeedback_text());
        feedback.setCreatedAt(LocalDateTime.now());

        RatingFeedback saved = service.saveFeedback(feedback);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/provider/{providerId}")
    public List<RatingFeedback> getFeedbackByProvider(@PathVariable Long providerId) {
        return service.getFeedbackByProvider(providerId);
    }
}
