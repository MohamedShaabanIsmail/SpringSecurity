package com.example.SpringSecurity.Model;

import com.example.SpringSecurity.Service.EncryptDecryptRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = EncryptDecryptRole.encrypt(role);
    }
    public String getRole() {
        return role;
    }
}
