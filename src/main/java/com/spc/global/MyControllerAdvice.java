package com.spc.global;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spc.customexception.EmptyInputException;

//global exception handler 
@ControllerAdvice
public class MyControllerAdvice {

	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleemptyinput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	
	public ResponseEntity<String> nosuch(NoSuchElementException nosuchelement){
		
		return new ResponseEntity<String>("lement not found",HttpStatus.BAD_REQUEST);
	}
}
