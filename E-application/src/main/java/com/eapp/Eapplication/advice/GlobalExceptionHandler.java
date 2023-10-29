package com.eapp.Eapplication.advice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eapp.Eapplication.dto.ErrorResponse;
import com.eapp.Eapplication.exception.DataNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex){
		
		logger.error("DataNotFoundException"+ ex.getMessage());
		ErrorResponse error=new ErrorResponse();
		error.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
