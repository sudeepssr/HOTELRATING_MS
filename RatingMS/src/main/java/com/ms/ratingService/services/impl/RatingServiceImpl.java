package com.ms.ratingService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.ratingService.entities.Rating;
import com.ms.ratingService.repositories.RatingRepo;
import com.ms.ratingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepo ratingRepo;
	
	
	@Override
	public Rating createHotel(Rating rating) {
		String randomRatingId= UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		Rating createdRating= ratingRepo.save(rating);
		return createdRating;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> ratings= ratingRepo.findAll();
		return ratings;
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		List<Rating> ratingByUsers= ratingRepo.findByUserId(userId);
		return ratingByUsers;
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		List<Rating> ratingByHotels= ratingRepo.findByHotelId(hotelId);
		return ratingByHotels;
	}

	

}
