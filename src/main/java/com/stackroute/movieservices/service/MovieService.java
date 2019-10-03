package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie);
    public Movie deleteMovie(int id);
    public List<Movie> getAllMovies();
    public Movie getMovie(int id);
    public Movie updateMovie(Movie movie);
    public List<Movie> findByTitle(String title);
}
