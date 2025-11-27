package com.project.controllers;

import com.project.dto.NotificationRequest;
import com.project.model.Notification;
import com.project.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("http://localhost:3000")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Notification createNotification(@RequestBody NotificationRequest req) {
        return service.save(req);
    }

    @GetMapping("/provider/{providerId}")
    public List<Notification> getProviderNotifications(@PathVariable Long providerId) {
        return service.getByProvider(providerId);
    }
//
//    @GetMapping("/user/{userId}")
//    public List<Notification> getUserNotifications(@PathVariable Long userId) {
//        return service.getUserNotifications(userId);
//    }
}
