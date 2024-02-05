package com.cg.WasherService.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WasherException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WasherException(String msg) {
		super(msg);
	}
	

}
