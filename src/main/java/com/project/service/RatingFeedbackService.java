package com.project.service;

import com.project.model.RatingFeedback;
import com.project.repository.RatingFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingFeedbackService {

    @Autowired
    private RatingFeedbackRepository repository;

    public RatingFeedback saveFeedback(RatingFeedback feedback) {
        return repository.save(feedback);
    }

    public List<RatingFeedback> getAllFeedback() {
        return repository.findAll();
    }

    public List<RatingFeedback> getFeedbackByProvider(Long providerId) {
        return repository.findFeedbackByProvider(providerId);
    }
}


