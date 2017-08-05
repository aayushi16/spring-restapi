package io.egen.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
		
		public NotFoundException(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}

		public NotFoundException(String message, Throwable cause) {
		
			// TODO Auto-generated constructor stub
			super(message, cause);
		}
}
