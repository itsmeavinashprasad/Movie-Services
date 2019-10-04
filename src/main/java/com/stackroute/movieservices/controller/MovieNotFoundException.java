package com.stackroute.movieservices.controller;

import com.stackroute.movieservices.exceptions.MovieException;

public class MovieNotFoundException extends MovieException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
