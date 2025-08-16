package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_provider_info")
public class ServiceProviderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerInfoId;

    @OneToOne
    @JoinColumn(name = "provider_id", nullable = false, unique = true)
    private User provider; // Must have role PROVIDER

    private String businessName;
    private String businessAddress;
    private String contactNumber;
    private String email;

    private String gstNumber; // Optional, if applicable
    private String fssaiLicenseNumber; // Food safety license

    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public ServiceProviderInfo() {}

    // Getters and Setters
    public Long getProviderInfoId() {
        return providerInfoId;
    }

    public void setProviderInfoId(Long providerInfoId) {
        this.providerInfoId = providerInfoId;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getFssaiLicenseNumber() {
        return fssaiLicenseNumber;
    }

    public void setFssaiLicenseNumber(String fssaiLicenseNumber) {
        this.fssaiLicenseNumber = fssaiLicenseNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
