package com.project.controllers;

import com.project.dto.SubscriptionRequest;
import com.project.model.Subscription;
import com.project.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // ------------------------------------------------------
    // CREATE A NEW SUBSCRIPTION
    // ------------------------------------------------------
    @PostMapping("/subscribe")
    public Subscription subscribe(@RequestBody SubscriptionRequest request) {
        return subscriptionService.createSubscription(
                request.getUserId(),
                request.getPlanId()
        );
    }

    // ------------------------------------------------------
    // GET SUBSCRIPTION DETAILS FOR A USER
    // ------------------------------------------------------
    @GetMapping("/subscriptions")
    public Subscription getSubscriptionByUser(@RequestParam Long userId) {
        return subscriptionService.getSubscriptionByUserId(userId);
    }
}
