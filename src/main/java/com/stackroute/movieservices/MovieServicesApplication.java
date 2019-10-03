package com.stackroute.movieservices;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.stackroute.movieservices.repository")
public class MovieServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commands(MovieRepository movieRepository){
		insertPersons(movieRepository);
		fin
		return null;
	}

	private void insertPersons(MovieRepository movieRepository){
		System.out.println("-> Inserting Persons");
		movieRepository.save(new Movie(1, "Movie 1", (float)6.1, "2004-01-01", false, "Overview 1"));
		movieRepository.save(new Movie(2, "Movie 2", (float)6.2, "2004-02-02", false, "Overview 2"));
		movieRepository.save(new Movie(3, "Movie 3", (float)6.3, "2004-03-03", true, "Overview 3"));
	}

	private void findMoviesAdultRated(MovieRepository movieRepository, Boolean isAdult){
		System.out.println("-> Finding movies where Adult: "+isAdult);
		List<Movie> movies = movieRepository.findMoviesAdultRated(isAdult);
		for(Movie movie: movies){
			System.out.println(movie.toString());
		}
	}

	private void findMoviesById(MovieRepository movieRepository, int id){
		System.out.println("-> Finding movies where id: "+id);
		List<Movie> movies = movieRepository.findMoviesById(id);
		for(Movie movie: movies){
			System.out.println(movie.toString());
		}
	}
}
