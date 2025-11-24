package com.project.service;

import com.project.model.Subscription;
import com.project.model.TiffinPlan;
import com.project.model.User;
import com.project.repository.SubscriptionRepository;
import com.project.repository.TiffinPlanRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TiffinPlanRepository planRepository;

    public Subscription createSubscription(Long userId, Long planId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TiffinPlan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlan(plan);

        // Set dates
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(plan.getDurationDays());

        subscription.setStartDate(start);
        subscription.setEndDate(end);

        // Calculate total
        double totalPrice = plan.getDurationDays() * plan.getPricePerDay();
        subscription.setTotalAmount(totalPrice);

        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionByUserId(Long userId) {
        return subscriptionRepository.findByUserUserId(userId);
    }

    public List<Subscription> getSubscriptionsByProvider(Long providerId) {
        return subscriptionRepository.findSubscriptionsByProviderId(providerId);
    }

}
