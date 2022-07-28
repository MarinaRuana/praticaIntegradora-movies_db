package com.example.movies.service;

import com.example.movies.models.Movies;

import java.util.List;

public interface IMoviesService {

    Movies save(Movies newMovie);

    boolean existsById(long id);

    List<Movies> saveAll(List<Movies> moviesList);
}
