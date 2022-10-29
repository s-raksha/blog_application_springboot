package com.example.blog.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.dao.CategoryRepo;
import com.example.blog.entity.Category;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo repo;
	@Autowired
	private ModelMapper modelMapper;

	// save
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		category = repo.save(category);
		return modelMapper.map(category, CategoryDto.class);
	}

	// read
	@Override
	public CategoryDto redCategory(Integer categoryId) {
		Category category = repo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", Long.valueOf(categoryId)));
		return modelMapper.map(category, CategoryDto.class);
	}

	// list
	@Override
	public List<CategoryDto> listCategories() {
		List<Category> categories = repo.findAll();
		return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	// delete
	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = repo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", Long.valueOf(categoryId)));
		repo.delete(category);
	}

	// update
	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
		Category category = repo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", Long.valueOf(categoryId)));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category = repo.save(category);
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, Map<String, Object> fieldsTobeUpdated) {
		Category category = repo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", Long.valueOf(categoryId)));
		fieldsTobeUpdated.entrySet().forEach(e -> {
			switch (e.getKey()) {
			case "categoryTitle":{
				category.setCategoryTitle(e.getValue().toString());
				break;
			}
			case "categoryDescription":{
				category.setCategoryDescription(e.getValue().toString());
				break;
			}
			default:{
//				throw 
				break;
			}
				
			}
		});
		return null;
	}

}
