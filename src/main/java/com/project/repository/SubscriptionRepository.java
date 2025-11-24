package com.project.repository;

import com.project.model.Subscription;
import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserUserId(Long userId);

    @Query("SELECT s FROM Subscription s WHERE s.plan.provider.userId = :providerId")
    List<Subscription> findSubscriptionsByProviderId(Long providerId);
}
