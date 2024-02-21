package com.ms.userService.entities;

import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	
	@Id
	private String userId;
	
	@Column(length= 15)
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings= new ArrayList<>();
	
	

}
