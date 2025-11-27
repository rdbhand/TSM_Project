package com.project.dto;

public class NotificationRequest {
    private String message;
    private String type;
    private Long providerId;

    public String getMessage() { return message; }
    public String getType() { return type; }
    public Long getProviderId() { return providerId; }
}
