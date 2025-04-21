package com.example.SpringSecurity.Reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    Users getByUsername(String username);
}
