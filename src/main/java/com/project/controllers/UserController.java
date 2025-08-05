package com.project.controllers;

import com.project.model.User;
import com.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

// Login Method here.......................................
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
        // 1. Find user by email or username
        Optional<User> existingUser = userService.getByEmail(user);

        if (existingUser.isPresent()) {
            // 2. Check password
            User dbUser = existingUser.get();

            if (dbUser.getPassword().equals(user.getPassword()) && dbUser.getRole().equals(user.getRole())) {
                // 3. Login success
                if(user.getRole()=="user"){
                    session.setAttribute("userSessionObj", dbUser);
                }
                else {
                    session.setAttribute("ServiceProviderSessionObj", dbUser);
                }
                return ResponseEntity.ok("Login successful");
            } else {
                // Wrong password
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            // User not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
