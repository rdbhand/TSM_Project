package com.project.controllers;

import com.project.model.User;
import com.project.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/users/register")
  public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.findAllUsers();
  }

  @PostMapping("/users/login")
  public Optional<User> login(@RequestBody User user) {
    return userService.findUserByEmail(user.getEmail());
  }

  @GetMapping("/user")
  public User getUserById(@RequestParam Long id) {
    return userService.getUserById(id);
  }

  @PutMapping("/users")
  public User updateUser(@RequestParam Long id, @RequestBody User updatedUser) {

    User existingUser = userService.getUserById(id);

    if (existingUser == null) {
      throw new RuntimeException("User not found with ID: " + id);
    }

    existingUser.setName(updatedUser.getName());
    existingUser.setPhone(updatedUser.getPhone());
    existingUser.setAddress(updatedUser.getAddress());

    if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
      existingUser.setPassword(updatedUser.getPassword());
    }

    return userService.saveUser(existingUser);
  }
}
