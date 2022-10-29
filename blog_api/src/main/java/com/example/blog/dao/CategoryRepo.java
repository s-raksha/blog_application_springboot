package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
