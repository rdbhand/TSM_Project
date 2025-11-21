package com.project.service;

import com.project.model.TiffinMenu;
import com.project.repository.TiffinMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TiffinMenuService {

    @Autowired
    private TiffinMenuRepository repository;

    public TiffinMenu saveOrUpdate(TiffinMenu newMenu) {
        Optional<TiffinMenu> existing = repository.findByProviderId(newMenu.getProviderId());

        if (existing.isPresent()) {
            TiffinMenu old = existing.get();

            old.setMondayLunch(newMenu.getMondayLunch());
            old.setMondayDinner(newMenu.getMondayDinner());

            old.setTuesdayLunch(newMenu.getTuesdayLunch());
            old.setTuesdayDinner(newMenu.getTuesdayDinner());

            old.setWednesdayLunch(newMenu.getWednesdayLunch());
            old.setWednesdayDinner(newMenu.getWednesdayDinner());

            old.setThursdayLunch(newMenu.getThursdayLunch());
            old.setThursdayDinner(newMenu.getThursdayDinner());

            old.setFridayLunch(newMenu.getFridayLunch());
            old.setFridayDinner(newMenu.getFridayDinner());

            old.setSaturdayLunch(newMenu.getSaturdayLunch());
            old.setSaturdayDinner(newMenu.getSaturdayDinner());

            old.setSundayLunch(newMenu.getSundayLunch());
            old.setSundayDinner(newMenu.getSundayDinner());

            return repository.save(old);
        }

        return repository.save(newMenu);
    }

    public Optional<TiffinMenu> getByProviderId(Long providerId) {
        return repository.findByProviderId(providerId);
    }
}
