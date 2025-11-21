package com.project.repository;

import com.project.model.TiffinPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiffinPlanRepository extends JpaRepository<TiffinPlan, Long> {

    // Returns all plans for a specific provider (userId)
    List<TiffinPlan> findByProviderUserId(Long userId);

}
