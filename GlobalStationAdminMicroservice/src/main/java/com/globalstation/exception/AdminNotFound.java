package com.globalstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFound extends RuntimeException{
    public AdminNotFound(String message){
        super(message);
    }
}
