package com.project.service;

import com.project.dto.NotificationRequest;
import com.project.model.Notification;
import com.project.model.User;
import com.project.repository.NotificationRepository;
import com.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository providerRepository;

    public NotificationService(NotificationRepository notificationRepository,
                               UserRepository providerRepository) {
        this.notificationRepository = notificationRepository;
        this.providerRepository = providerRepository;
    }

    public Notification save(NotificationRequest request) {
        User provider = providerRepository.findById(request.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        Notification notification = new Notification();
        notification.setMessage(request.getMessage());
        notification.setType(request.getType());
        notification.setProvider(provider);

        return notificationRepository.save(notification);
    }

    public List<Notification> getByProvider(Long providerId) {
       User provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return notificationRepository.findByProviderOrderByCreatedAtDesc(provider);
    }

//    public List<Notification> getUserNotifications(Long userId) {
//        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
//    }
}
