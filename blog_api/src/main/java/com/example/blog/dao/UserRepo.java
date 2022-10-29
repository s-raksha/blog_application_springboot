package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
