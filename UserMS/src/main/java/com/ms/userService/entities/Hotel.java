package com.ms.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	private String ratingId;
	
	private String hotelId;
	
	private String userId;
	
	private String name;
	
	private String location;
	
	private String about;
}

