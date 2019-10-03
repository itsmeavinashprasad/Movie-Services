package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl() {
    }

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public Movie deleteMovie(int id){
        Movie movie = getMovie(id);
        movieRepository.deleteById(id);
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) {
            return movieRepository.findById(id).get();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie newMovie = movieRepository.getOne(movie.getId());
        if(movie.getTitle() != null){
            newMovie.setTitle(movie.getTitle());
        }
        if(movie.getVoteAverage() != 0){
            newMovie.setVoteAverage(movie.getVoteAverage());
        }
        if(movie.getAdult() == null){
            newMovie.setAdult(movie.getAdult());
        }
        if(movie.getOverview() != null){
            newMovie.setOverview(movie.getOverview());
        }
        if (movie.getReleaseDate() != null){
            newMovie.setReleaseDate(movie.getReleaseDate());
        }
        movieRepository.save(newMovie);
        return newMovie;
    }

    @Override
    public List<Movie> findByTitle(String title){
        return movieRepository.findByTitle(title);
    }
}
