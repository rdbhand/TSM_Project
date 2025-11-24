package com.project.controllers;

import com.project.model.TiffinMenu;
import com.project.service.TiffinMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiffin-menu")
@CrossOrigin("*")
public class TiffinMenuController {

    @Autowired
    private TiffinMenuService service;

    // Save or update a single day's menu
    @PostMapping("/save")
    public TiffinMenu saveMenu(@RequestBody TiffinMenu menu) {
        return service.saveOrUpdate(menu);
    }

    // Get today's menu (existing behavior)
    @GetMapping("/{providerId}")
    public TiffinMenu getMenu(@PathVariable Long providerId) {
        return service.getByProviderId(providerId)
                .orElse(null);
    }

}
