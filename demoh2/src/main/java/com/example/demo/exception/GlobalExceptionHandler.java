package com.example.demo.exception;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.model.CustomResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
    CustomResponse custResp;
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomResponse> handleInvalidMethdArgEx(IllegalArgumentException ex, HttpServletResponse res){
   	
       
       	custResp.setCode("3");
       	custResp.setDesc("IllegalArgumentException ");
       	custResp.setMsg("IllegalArgumentException occured");
       
     
       return new ResponseEntity<>(custResp,HttpStatus.OK);
   }
   
}
