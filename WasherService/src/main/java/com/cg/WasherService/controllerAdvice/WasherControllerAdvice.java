package com.cg.WasherService.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.WasherService.exception.WasherException;

@RestControllerAdvice
public class WasherControllerAdvice {
	
	@ExceptionHandler(WasherException.class)
    public ResponseEntity<String> WasherServiceException(WasherException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
      return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
  }

}
