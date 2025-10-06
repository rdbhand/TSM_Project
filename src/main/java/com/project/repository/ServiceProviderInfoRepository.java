package com.project.repository;

import com.project.model.ServiceProviderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceProviderInfoRepository extends JpaRepository<ServiceProviderInfo, Long> {
    Optional<ServiceProviderInfo> findByProvider_UserId(Long providerId);
}
