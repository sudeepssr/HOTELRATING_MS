package com.ms.userService.services;

import java.util.List;

import com.ms.userService.entities.User;

public interface UserService {
	
	User createUser(User user);
	List<User> getAllUsers();
	User getUserById(String userId);
	void deleteUser(String userId);
	User updateUser(String userId, User user);
	
}
