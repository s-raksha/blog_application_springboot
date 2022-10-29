package com.example.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payloads.CategoryDto;
import com.example.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create
	@RequestMapping(method = RequestMethod.POST, path = "/")
	private ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto respose = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(respose, HttpStatus.CREATED);
	}

	// read
	@RequestMapping(method = RequestMethod.GET, path = "/{categoryId}")
	public ResponseEntity<CategoryDto> readCategory(@PathVariable Integer categoryId) {
		CategoryDto categoryDto = categoryService.redCategory(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}

	// list
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public ResponseEntity<List<CategoryDto>> listCateries() {
		List<CategoryDto> categoryDtos = categoryService.listCategories();
		return ResponseEntity.ok(categoryDtos);
	}
	
	// update
	@RequestMapping(method = RequestMethod.PUT, path="/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer categoryId,
			@RequestBody CategoryDto categoryDto){
		return ResponseEntity.ok(categoryService.updateCategory(categoryId, categoryDto));
	}
	
	// delete
	@RequestMapping(method = RequestMethod.PATCH, path="/{CategoryId}")
	public ResponseEntity<CategoryDto> updateCargory(@PathVariable Integer categoryId,
			@RequestBody Map<String, Object> fieldsTobeUpdated){
		return ResponseEntity.ok(categoryService.updateCategory(categoryId, fieldsTobeUpdated));
	}

}
