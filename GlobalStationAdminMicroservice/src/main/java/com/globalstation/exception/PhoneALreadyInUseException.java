package com.globalstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PhoneALreadyInUseException extends RuntimeException {
	public PhoneALreadyInUseException(String message) {
		super(message);
	}
}
