package com.project.repository;

import com.project.model.TiffinMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiffinMenuRepository extends JpaRepository<TiffinMenu, Long> {
    Optional<TiffinMenu> findByProviderId(Long providerId);
}
