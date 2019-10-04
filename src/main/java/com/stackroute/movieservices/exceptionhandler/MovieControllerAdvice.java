package com.stackroute.movieservices.exceptionhandler;

import com.stackroute.movieservices.controller.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> movieAlreadyExistsExceptionHandler(MovieAlreadyExistsException e){

    }
}
