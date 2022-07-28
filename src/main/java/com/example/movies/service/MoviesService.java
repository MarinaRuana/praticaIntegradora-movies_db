package com.example.movies.service;

import com.example.movies.models.Movies;
import com.example.movies.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private MoviesRepo moviesRepo;

    @Override
    public Movies save(Movies newMovie){
       return moviesRepo.save(newMovie);
    }

    @Override
    public boolean existsById(long id) {
        return moviesRepo.existsById(id);
    }

    @Override
    public List<Movies> saveAll(List<Movies> moviesList) {
        return (List<Movies>) moviesRepo.saveAll(moviesList);
    }
}
