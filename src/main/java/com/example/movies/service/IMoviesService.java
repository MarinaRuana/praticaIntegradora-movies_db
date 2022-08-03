package com.example.movies.service;

import com.example.movies.models.Movies;

import java.util.List;

public interface IMoviesService {

    Movies saveMovies(Movies newMovie);

    boolean existsMoviesById(long id);

    List<Movies> saveAllMovies(List<Movies> moviesList);
}
