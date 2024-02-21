package com.ms.userService.controllers;

import java.util.List;

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

import com.ms.userService.entities.User;
import com.ms.userService.services.UserService;

@RestController
@RequestMapping("/userMs")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUserMapping(@RequestBody User user){
		User userCreated= userService.createUser(user);
		return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity< List<User> > getAllUsers(){
		List<User> users= userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User userFound= userService.getUserById(userId);
		return new ResponseEntity<>(userFound, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId){
		User updatedUser= userService.updateUser(userId, user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
}
