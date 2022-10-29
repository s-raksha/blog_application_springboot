package com.example.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min=4, message = "User name must be minimum of 4 characters.")
	private String name;

	@NotEmpty
	@Email(message = "Email id is not valid.")
	private String email;

	@NotEmpty
	@Size(min=8, max= 20, message = "password must be minimum of 8 characters and maximum of 20 characters.")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$",
//	message = "password must contain at least 1 capital case, 1 small case, 1 digit, 1 special char, and can not cointain spaces "
//			+ "and length must be in between 8 to 20")
	private String password;

	@NotEmpty
	private String about;
}
