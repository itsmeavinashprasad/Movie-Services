package com.stackroute.movieservices.seeddata;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PreFillCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-> Pre-Fill using CommandLineRunner");
        movieRepository.save(new Movie(
                4,
                "Movie 4",
                (float) 7.4,
                "5009-04-04",
                true,
                "Overview 4"
        ));

        movieRepository.save(new Movie(
                5,
                "Movie 5",
                (float) 7.5,
                "5009-05-05",
                true,
                "Overview 5"
        ));
        movieRepository.save(new Movie(
                6,
                "Movie 6",
                (float) 7.6,
                "5009-06-06",
                false,
                "Overview 6"
        ));
    }
}
