package com.ms.ratingService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ratingService.entities.Rating;
import com.ms.ratingService.services.RatingService;

@RestController
@RequestMapping("/ratingMS/")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/allRatings")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratingAll= ratingService.getAllRatings();
		return new ResponseEntity<>(ratingAll, HttpStatus.OK);
	}
	
	@PostMapping("/createRating")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		Rating addedRating= ratingService.createHotel(rating);
		return new ResponseEntity<>(addedRating, HttpStatus.OK);
	}
	
	@GetMapping("/findByUserId/{userId}")
	public ResponseEntity< List<Rating> > findRatingsByUserId(@PathVariable String userId){
		List< Rating> allRatings= ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<>(allRatings, HttpStatus.OK);
	}
	
	@GetMapping("/findByHotelId/{hotelId}")
	public ResponseEntity< List<Rating> > findRatingsByHotelId(@PathVariable String hotelId){
		List< Rating> allRatings= ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<>(allRatings, HttpStatus.OK);
	}
 }
