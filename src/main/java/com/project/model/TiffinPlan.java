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
    @JoinColumn(name = "provider", nullable = false)
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

    public TiffinPlan() {
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
