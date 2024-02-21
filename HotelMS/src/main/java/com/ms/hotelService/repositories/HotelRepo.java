package com.ms.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hotelService.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String>{

}
