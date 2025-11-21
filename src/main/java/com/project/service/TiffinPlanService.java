package com.project.service;

import com.project.model.TiffinPlan;
import com.project.model.User;
import com.project.repository.TiffinPlanRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiffinPlanService {

    @Autowired
    private TiffinPlanRepository tiffinPlanRepository;

    @Autowired
    private UserRepository userRepository;

    public void savePlan(TiffinPlan plan) {

        // Extract ID sent from React
        Long providerId = plan.getProvider().getUserId();

        // Fetch persisted user
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found with ID: " + providerId));

        // Replace transient user with managed entity
        plan.setProvider(provider);

        // Save plan safely
        tiffinPlanRepository.save(plan);
    }

    // Get all plans by provider_id
    public List<TiffinPlan> getPlansByProvider(Long providerId) {
        return tiffinPlanRepository.findByProviderUserId(providerId);
    }

    public List<TiffinPlan> getAllPlans(){
        return tiffinPlanRepository.findAll();
    }
}
