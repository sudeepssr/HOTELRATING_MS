package com.ms.userService.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.userService.entities.Hotel;
import com.ms.userService.entities.Rating;
import com.ms.userService.entities.User;
import com.ms.userService.exceptions.ResourceNotFoundException;
import com.ms.userService.repositories.UserRepo;
import com.ms.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public User createUser(User user) {
		String randomUserID= UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		User createdUser= userRepo.save(user);
		return createdUser;
	}
	
	public List<User> getAllUsers(){
		List<User> userList= userRepo.findAll();
		return userList;
	}
	
	public User getUserById(String id) {
		User foundUser= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with userID: "+id));
		Rating[] ratings= restTemplate.getForObject("http://localhost:8083/ratingMS/findByUserId/"+ foundUser.getUserId(), Rating[].class);
		
		List<Rating> ratingsByUser= Arrays.stream(ratings).toList();
		
		List<Rating> ratingsList= ratingsByUser.stream().map(rating->{
			Hotel hotelRated= restTemplate.getForObject("http://localhost:8082/hotelMs/getHotel/"+ rating.getHotelId(), Hotel.class);
			rating.setHotel(hotelRated);
			return rating;
		}).collect(Collectors.toList());
		
		foundUser.setRatings(ratingsList);
		userRepo.save(foundUser);
		return foundUser;
	}
	
	public void deleteUser(String id) {
		User foundUser= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with userID: "+id));
		userRepo.delete(foundUser);
		
	}
	
	public User updateUser(String id,User user) {
		User foundUser= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with userID: "+id));
		foundUser.setName(user.getName());
		foundUser.setEmail(user.getEmail());
		foundUser.setAbout(user.getAbout());
		userRepo.save(foundUser);
		return foundUser;
	}

	
}
