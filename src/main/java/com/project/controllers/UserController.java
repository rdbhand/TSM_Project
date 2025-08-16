package com.project.controllers;

import com.project.model.User;
import com.project.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;




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
  
  
  
}