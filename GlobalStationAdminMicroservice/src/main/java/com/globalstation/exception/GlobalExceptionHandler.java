package com.globalstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {

	@ExceptionHandler(value	= EmailAlreadyInUseException.class)
	public ResponseEntity<String> handleEmailAlreadyInUseException(EmailAlreadyInUseException e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value	= EmailNotFoundException.class)
	public ResponseEntity<String> handleEmailNotFoundException(EmailNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = AdminNotFound.class)
	public  ResponseEntity<String> handleAdminNotFound(AdminNotFound e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PhoneALreadyInUseException.class)
	public ResponseEntity<String> handlePhoneNotFound(PhoneALreadyInUseException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
	}



}
