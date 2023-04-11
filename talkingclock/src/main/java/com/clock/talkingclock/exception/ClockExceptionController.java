package com.clock.talkingclock.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClockExceptionController {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> exception(IllegalArgumentException exception){
		
		return new ResponseEntity<>("Please enter valid time in HH:MM format.", HttpStatus.NOT_ACCEPTABLE);
	}
}
