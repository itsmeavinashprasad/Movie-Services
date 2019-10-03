package com.stackroute.movieservices.controller;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.errors.CustomErrors;
import com.stackroute.movieservices.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "Movie Services Rest API")
public class MovieController {
    private MovieService movieService;

    public MovieController() {
    }

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "Add a Movie")
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

    @ApiOperation(value = "Delete a Movie from Database using movie_id")
    @DeleteMapping(value = "movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        ResponseEntity responseEntity;
        try{
            System.out.println("deleteMovie(): id = "+ id);
            responseEntity = new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.NO_CONTENT);
        }catch (Exception e){
            responseEntity = new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @ApiOperation(value = "List of All movies present in the Database")
    @GetMapping(value = "movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get information about a Movie providing its movie_id")
    @GetMapping(value = "movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id){
        try{
            return new ResponseEntity<Movie>(movieService.getMovie(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<CustomErrors>(new CustomErrors(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Update information of a Movie")
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

    @ApiOperation(value = "List of all movies of given title")
    @GetMapping("movieByTitle/{title}")
    public ResponseEntity<?> findMovieByTitle(@PathVariable String title){
        ResponseEntity responseEntity;
        return new ResponseEntity<List<Movie>>(movieService.findByTitle(title), HttpStatus.OK);
    }
}
