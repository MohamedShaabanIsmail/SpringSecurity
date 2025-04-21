package com.example.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.Model.Users;
import com.example.SpringSecurity.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Users user) {
        return userService.verify(user);
    }
    
    @GetMapping("/refreshtoken")
    public Map<String, String> getNewToken(HttpServletRequest request) {
        String token = request.getHeader("Athorization");
        if(token != null)
            System.out.println("token is null");
        return userService.newAccessToken(token);
    }
    
}
