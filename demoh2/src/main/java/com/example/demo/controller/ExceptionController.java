package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomResponse;

@RestController
public class ExceptionController {

	@Autowired
    CustomResponse custResp;
	
	@GetMapping("/chkExcep/{Id}")
	public ResponseEntity<CustomResponse> checkExcep(@PathVariable Long Id){
	if(Id==2) {
	throw new IllegalArgumentException();
	}
	return new ResponseEntity<CustomResponse>(custResp,HttpStatus.OK);

	}
}
