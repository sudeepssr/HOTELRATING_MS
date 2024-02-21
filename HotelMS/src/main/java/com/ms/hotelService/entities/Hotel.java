package com.ms.hotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Hotel")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Hotel {

	@Id
	private String hotelId;
	
	private String name;
	
	private String location;
	
	private String about;
}
