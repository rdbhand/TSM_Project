package com.project.controllers;

import com.project.model.ServiceProviderInfo;
import com.project.model.User;
import com.project.repository.ServiceProviderInfoRepository;
import com.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/providers-info")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class ServiceProviderInfoController {

    @Autowired
    private ServiceProviderInfoRepository serviceProviderInfoRepository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<?> createProviderInfo(@RequestBody ServiceProviderInfo providerInfo) {
        Long providerId = providerInfo.getProvider().getUserId();
        Optional<User> provider = userRepository.findById(providerId);

        if (provider.isEmpty()) {
            return ResponseEntity.badRequest().body("Provider not found with ID: " + providerId);
        }

//         Check role
//        if (!"serviceProvider".equalsIgnoreCase(provider.get().getRole())) {
//            return ResponseEntity.badRequest().body("User is not a service provider!");
//        }

        // Set provider and createdAt
        providerInfo.setProvider(provider.get());
        providerInfo.setCreatedAt(LocalDateTime.now());

        // Save to DB
        ServiceProviderInfo saved = serviceProviderInfoRepository.save(providerInfo);
        return ResponseEntity.ok(saved);
    }

    // Get All Provider Info
    @GetMapping
    public List<ServiceProviderInfo> getAllProviders() {
        return serviceProviderInfoRepository.findAll();
    }

    // Get Provider Info by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProviderInfoById(@PathVariable Long id) {
        return serviceProviderInfoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Provider Info by Provider ID
    @GetMapping("/by-provider/{providerId}")
    public ResponseEntity<?> getByProviderId(@PathVariable Long providerId) {
        Optional<ServiceProviderInfo> info = serviceProviderInfoRepository.findByProvider_UserId(providerId);
        return info.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update Provider Info
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProviderInfo(@PathVariable Long id, @RequestBody ServiceProviderInfo updatedInfo) {
        return serviceProviderInfoRepository.findById(id).map(existing -> {
            existing.setBusinessName(updatedInfo.getBusinessName());
            existing.setBusinessAddress(updatedInfo.getBusinessAddress());
            existing.setContactNumber(updatedInfo.getContactNumber());
            existing.setEmail(updatedInfo.getEmail());
            existing.setFssaiLicenseNumber(updatedInfo.getFssaiLicenseNumber());
            existing.setGstNumber(updatedInfo.getGstNumber());
            return ResponseEntity.ok(serviceProviderInfoRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    //  Delete Provider Info
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProviderInfo(@PathVariable Long id) {
        if (!serviceProviderInfoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceProviderInfoRepository.deleteById(id);
        return ResponseEntity.ok("Provider info deleted successfully!");
    }
}
