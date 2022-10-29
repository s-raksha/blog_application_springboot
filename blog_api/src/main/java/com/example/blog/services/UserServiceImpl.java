package com.example.blog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.dao.UserRepo;
import com.example.blog.entity.User;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto saveUser(UserDto userDto) {
		return userToUserDto(userRepo.save(userDtoToUser(userDto)));
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", Long.valueOf(userId)));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return userToUserDto(userRepo.save(user));
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", Long.valueOf(userId)));
		return userToUserDto(user);
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> UserDtos = users.stream().map(user -> userToUserDto(user)).collect(Collectors.toList());
		return UserDtos;
	}

	@Override
	public UserDto deleteUser(Integer userId) {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "UserId", Long.valueOf(userId)));
		userRepo.delete(user);
		return userToUserDto(user);
	}

	private User userDtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	private UserDto userToUserDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

}
