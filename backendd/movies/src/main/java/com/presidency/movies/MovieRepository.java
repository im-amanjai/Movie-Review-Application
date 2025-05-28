package com.presidency.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; //Optional is used to handle cases where a movie might not be found.

@Repository

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
   //This is a custom finder method.
   //
   //Spring Boot automatically translates this method name into a MongoDB query:
   //
   //It queries the movies collection using the imdbId field.
   //
   //Returns an Optional<Movies> to handle both found and not-found cases gracefully.
   Optional<Movie> findMovieByImdbId(String imdbId);
}
//4. Repository Layer
//“The MovieRepo interface extends MongoRepository, so I get built-in methods like findAll(), save(), and delete(). I also added a custom query method findByImdbId(String imdbId) to fetch a movie by its IMDb ID.”
//“The MovieRepo interface is part of the repository layer. It extends MongoRepository which gives us all basic CRUD operations out-of-the-box. I’ve added a custom query method findMovieByImdbId to search for a movie using its IMDb ID. This helps separate database logic from the controller and service layers, making the code cleaner and more maintainable.”
//The repository layer is responsible for:
//
//Communicating directly with the MongoDB database
//
//Performing CRUD operations (Create, Read, Update, Delete)
//
//Abstracting away the database logic so that the service and controller layers don't deal with raw queries