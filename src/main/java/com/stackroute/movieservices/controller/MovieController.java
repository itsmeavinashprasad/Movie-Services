package com.stackroute.movieservices.controller;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.errors.CustomErrors;
import com.stackroute.movieservices.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    private MovieService movieService;

    public MovieController() {
    }

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping(value = "movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            System.out.println("saveMovie(): "+ movie.toString());
            responseEntity = new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.CONFLICT), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        ResponseEntity responseEntity;
        try{
            System.out.println("deleteMovie(): id = "+ id);
            Movie movie = movieService.deleteMovie(id);
            System.out.println("deleteMovie(): "+movie.toString());
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping(value = "movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping(value = "movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id){
        try{
            return new ResponseEntity<Movie>(movieService.getMovie(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            System.out.println("updateMovie(): "+ movie.toString());
            responseEntity = new ResponseEntity<Movie>(movieService.updateMovie(movie), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
