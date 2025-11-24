package com.project.controllers;

import com.project.dto.SubscriptionRequest;
import com.project.model.Subscription;
import com.project.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Subscription> getSubscriptionByUser(@RequestParam Long userId) {
        return subscriptionService.getSubscriptionByUserId(userId);
    }

    // ------------------------------------------------------
    // GET SUBSCRIBED USERS DETAILS FOR A SERVICE PROVIDER
    // ------------------------------------------------------

    @GetMapping("subscriptions/provider/{providerId}")
    public List<Subscription> getSubscriptionsByProvider(@PathVariable Long providerId) {
        return subscriptionService.getSubscriptionsByProvider(providerId);
    }

}
