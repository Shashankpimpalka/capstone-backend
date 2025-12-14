package com.globalstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActorNotFound extends RuntimeException {
    public ActorNotFound(String message){
        super(message);
    }

}
