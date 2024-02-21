package com.ms.ratingService.services;

import java.util.List;

import com.ms.ratingService.entities.Rating;

public interface RatingService {

	Rating createHotel(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingsByHotelId(String hotelId);
	
}
