package com.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long user_id;
    @Column
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column
    private String role;
    @Column
    private String address;
    @Column
    private Date created_at;
    @Column
    private String password;
    @Column
    private String phone;

    public Long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
