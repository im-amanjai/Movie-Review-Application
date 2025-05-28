package com.presidency.movies;

import org.springframework.beans.factory.annotation.Autowired; // is used for dependency injection.
import org.springframework.stereotype.Service; //marks this class as a service component.

import java.util.List;
import java.util.Optional;

@Service //tells Spring that this class provides business logic.
public class MovieService {

    @Autowired
    private MovieRepository movieRepo; //Spring injects an instance of MovieRepo here.
    //This allows the service to use the repository methods without manually instantiating it.
    public List<Movie> allMovies(){
       return movieRepo.findAll();
    }
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
