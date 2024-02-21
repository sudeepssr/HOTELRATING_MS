package com.ms.hotelService.Services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hotelService.Services.HotelServices;
import com.ms.hotelService.entities.Hotel;
import com.ms.hotelService.exceptions.ResourceNotFoundException;
import com.ms.hotelService.repositories.HotelRepo;

@Service
public class HotelServicesImpl implements HotelServices{

	@Autowired
	private HotelRepo hotelRepo;
	
	public Hotel createHotel(Hotel hotel) {
		String randomHotelId= UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		Hotel createdHotel= hotelRepo.save(hotel);
		return createdHotel;
	}
	
	public List<Hotel> getAllHotels(){
		List<Hotel> hotels= hotelRepo.findAll();
		return hotels;
	}
	
	public Hotel getHotelById(String hotelId){
		Hotel foundHotel= hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with hotelId: "+ hotelId));
		return foundHotel;
		
	}
	
	public void deleteHotel(String hotelId) {
		Hotel foundHotel= hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with hotelId: "+ hotelId));
		hotelRepo.delete(foundHotel);
	}
	
	public Hotel updateHotel(String hotelId, Hotel hotel) {
		Hotel foundHotel= hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with hotelId: "+ hotelId));
		foundHotel.setName(foundHotel.getName());
		foundHotel.setAbout(foundHotel.getAbout());
		foundHotel.setLocation(foundHotel.getLocation());
		hotelRepo.save(foundHotel);
		return foundHotel;
	}
	
}
