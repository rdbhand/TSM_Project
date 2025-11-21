package com.project.controllers;

import com.project.model.TiffinMenu;
import com.project.service.TiffinMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tiffin-menu")
@CrossOrigin("*")
public class TiffinMenuController {

    @Autowired
    private TiffinMenuService service;

    @PostMapping("/save")
    public TiffinMenu saveMenu(@RequestBody TiffinMenu menu) {
        return service.saveOrUpdate(menu);
    }

    @GetMapping("/{providerId}")
    public TiffinMenu getMenu(@PathVariable Long providerId) {
        return service.getByProviderId(providerId).orElse(null);
    }
}
