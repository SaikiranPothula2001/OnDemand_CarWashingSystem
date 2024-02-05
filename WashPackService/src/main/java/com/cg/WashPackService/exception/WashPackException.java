package com.cg.WashPackService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WashPackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WashPackException (String msg) {
		super(msg);
	}

}
