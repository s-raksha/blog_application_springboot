package com.example.blog.services;

import java.util.List;
import java.util.Map;

import com.example.blog.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto categoryDto);

	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);
	
	public CategoryDto updateCategory(Integer categoryId,Map<String, Object> fieldsTobeUpdated);

	public CategoryDto redCategory(Integer categoryId);

	public List<CategoryDto> listCategories();

	public void deleteCategory(Integer categoryId);

}
