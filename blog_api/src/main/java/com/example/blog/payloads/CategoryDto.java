package com.example.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;

	@NotEmpty
	@Size(min = 3, message = "CategoryTitle must be atleast 3 characters")
	private String categoryTitle;

	@NotEmpty
	@Size(min = 3, message = "categoryDescription must be atleast 3 characters")
	private String categoryDescription;
}
