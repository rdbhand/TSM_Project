package com.project.controllers;

import com.project.model.TiffinPlan;
import com.project.model.User;
import com.project.service.TiffinPlanService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TiffinPlanController {

    @Autowired
    private TiffinPlanService tiffinPlanService;

    @Autowired
    private UserService userService;

    @PostMapping("/plans")
    public String addPlan(@RequestBody TiffinPlan plan) {
        try {
            // *** IMPORTANT FIX ***
            // Extract provider ID from the incoming JSON
            Long providerId = plan.getProvider().getUserId();

            // Fetch user from DB (must be a managed entity)
            User providerFromDb = userService.getUserById(providerId);

            if (providerFromDb == null) {
                return "Error: Provider user not found!";
            }

            // Set the fetched user into the plan
            plan.setProvider(providerFromDb);

            // Save plan
            tiffinPlanService.savePlan(plan);

            return "Plan added successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding plan: " + e.getMessage();
        }
    }

    @GetMapping("plans")
    public List<TiffinPlan> getTiffinPlans(@RequestParam Long providerId){
        List<TiffinPlan> res=tiffinPlanService.getPlansByProvider(providerId);
        return res;
    }

    @GetMapping("allplans")
    public List<TiffinPlan> getAllTiffinPlans(){
        List<TiffinPlan> res=tiffinPlanService.getAllPlans();
        return res;
    }
}
