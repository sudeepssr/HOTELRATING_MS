package com.ms.hotelService.controllers;

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

import com.ms.hotelService.Services.HotelServices;
import com.ms.hotelService.entities.Hotel;

@RestController
@RequestMapping("/hotelMs/")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel addedHotel= hotelServices.createHotel(hotel);
		return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
	}
	
	@GetMapping("/getHotels")
	public ResponseEntity< List<Hotel> > getAllHotels(){
		List<Hotel> allHotel= hotelServices.getAllHotels();
		return new ResponseEntity<>(allHotel, HttpStatus.OK);
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		Hotel hotel= hotelServices.getHotelById(hotelId);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	
	@PutMapping("/updateHotel/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel){
		Hotel updatedHotel= hotelServices.updateHotel(hotelId, hotel);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteHotel/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
		hotelServices.deleteHotel(hotelId);
		return new ResponseEntity<>("Hotel deleted successfully!!", HttpStatus.OK);
		
	}
	
	
	
}
