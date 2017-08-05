package io.egen.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public BadRequestException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message, cause);
	}
}
