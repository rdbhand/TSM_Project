package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tiffin_plans")
public class TiffinPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private User provider;

    private String name;
    private String description;

    private Double pricePerDay;
    private Integer durationDays;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private Boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum MealType {
        LUNCH, DINNER, BOTH
    }

    // Getters and Setters
}
