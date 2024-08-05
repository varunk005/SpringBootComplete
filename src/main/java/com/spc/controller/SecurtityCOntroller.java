package com.spc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc")
public class SecurtityCOntroller {

	
	@GetMapping("/normal")
	public ResponseEntity<String> normaluser(){
		
		return new ResponseEntity<String>("Normal User",HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminuser(){
		
		return new ResponseEntity<String>("admin User",HttpStatus.OK);
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicuser(){
		
		return new ResponseEntity<String>("public User",HttpStatus.OK);
	}
	
}
