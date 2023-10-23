package com.eapp.Eapplication.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eapp.Eapplication.exception.DataNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Map<String, String>> hanldeDataNotFoundException(DataNotFoundException ex){
		Map<String, String> errors=new HashMap<String, String>();
		errors.put("Message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}

}
