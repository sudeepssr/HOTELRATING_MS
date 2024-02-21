package com.ms.hotelService.Services;

import java.util.List;

import com.ms.hotelService.entities.Hotel;

public interface HotelServices {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotelById(String hotelId);
	
	Hotel updateHotel(String hotelId, Hotel hotel);
	
	void deleteHotel(String hotelId);
	
	
	
}
