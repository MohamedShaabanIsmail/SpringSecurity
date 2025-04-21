package com.example.SpringSecurity.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.Model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
    
    private List<Student> students = new ArrayList<>(List.of(new Student(1,"Ali"),new Student(2,"Alaa")));

    @GetMapping("/students")
    public List<Student> getMethodName() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;   
    }
    
}
