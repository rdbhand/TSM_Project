package com.project.repository;

import com.project.model.RatingFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RatingFeedbackRepository extends JpaRepository<RatingFeedback, Long> {

    // Fetch feedbacks for provider (via plan → subscription → feedback)
    @Query("SELECT f FROM RatingFeedback f " +
            "WHERE f.subscription.plan.provider.userId = :providerId")
    List<RatingFeedback> findFeedbackByProvider(Long providerId);
}
