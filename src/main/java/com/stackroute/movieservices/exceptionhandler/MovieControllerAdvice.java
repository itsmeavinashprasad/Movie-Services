package com.stackroute.movieservices.exceptionhandler;

import com.stackroute.movieservices.errors.CustomErrors;
import com.stackroute.movieservices.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservices.exceptions.MovieException;
import com.stackroute.movieservices.exceptions.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> movieAlreadyExistsExceptionHandler(MovieAlreadyExistsException e){
        String httpError = e.getClass().toString()+": "+e.getMessage();
        return new ResponseEntity<CustomErrors>(new CustomErrors(httpError, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> movieNotFoundExceptionHandler(MovieNotFoundException e){
        String httpError = e.getClass().toString()+": "+e.getMessage();
        return new ResponseEntity<CustomErrors>(new CustomErrors(httpError, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }


}
