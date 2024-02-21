package com.ms.userService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String msg= ex.getMessage();
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}
	
}
