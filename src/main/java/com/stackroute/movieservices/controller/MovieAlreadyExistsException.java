package com.stackroute.movieservices.controller;

import com.stackroute.movieservices.exceptions.MovieException;

public class MovieAlreadyExistsException extends MovieException {
    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
