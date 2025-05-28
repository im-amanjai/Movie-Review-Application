package com.presidency.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = {
//        "http://localhost:3000",
//        "https://9c96-103-106-239-104.ap.ngrok.io"
//})
@CrossOrigin(origins = "*")

@RestController //This tells Spring that this class handles HTTP requests and returns JSON responses.
@RequestMapping("/api/v1/movies") //This sets the base URL path for all endpoints in this controller. So, http://localhost:8080/api/v1/movies is the base endpoint
public class MovieController {
    @Autowired
    private MovieService movieService; // The controller calls methods from this service instead of directly accessing the database or repository.

    @GetMapping //Maps HTTP GET requests to this method.
    public ResponseEntity<List<Movie>> getallMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK); //Calls the service layer's allMovies() method.
        //Returns a list of all movies with status code 200 OK.
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}

//@PathVariable: Extracts the imdbId from the URL.
//Calls the service's singleMovie(imdbId) method.
