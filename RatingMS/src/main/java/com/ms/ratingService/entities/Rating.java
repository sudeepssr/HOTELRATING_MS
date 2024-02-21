package com.ms.ratingService.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "ratings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private String rating;
	
	private String feedback;

	
	
}
