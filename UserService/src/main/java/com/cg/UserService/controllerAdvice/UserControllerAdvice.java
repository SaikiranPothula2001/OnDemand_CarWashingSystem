package com.cg.UserService.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.UserService.exception.UserException;

@RestControllerAdvice
public class UserControllerAdvice {
	
	
	@ExceptionHandler(UserException.class)
    public ResponseEntity<String> UserServiceException(UserException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
      return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
  }

}
