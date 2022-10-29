package com.example.blog.services;

import java.util.List;

import com.example.blog.payloads.UserDto;

public interface UserService {
	
	public UserDto saveUser(UserDto userDto);
	
	public UserDto updateUser(Integer userId, UserDto userDto);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getUsers();
	
	public UserDto deleteUser(Integer userId);

}
