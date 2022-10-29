package com.example.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payloads.UserDto;
import com.example.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto usedto) {
		UserDto userDto =  userService.saveUser(usedto);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED); 			
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(userService.getUserById(userId));
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto usedto,
			@PathVariable Integer userId) {
		UserDto userDto =  userService.updateUser(userId,usedto);		
		return ResponseEntity.ok(userDto); 			
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok(Map.of("message :", "User deleted Sucessfully"));
	}
}
