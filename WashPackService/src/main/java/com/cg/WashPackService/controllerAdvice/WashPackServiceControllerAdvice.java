package com.cg.WashPackService.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.WashPackService.exception.WashPackException;



@RestControllerAdvice
public class WashPackServiceControllerAdvice {
	@ExceptionHandler(WashPackException.class)
    public ResponseEntity<String> WashPackServiceException(WashPackException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
      return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
  }

}
