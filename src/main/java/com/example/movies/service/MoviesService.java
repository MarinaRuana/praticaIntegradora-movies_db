package com.example.movies.service;

import com.example.movies.models.Actors;
import com.example.movies.models.Movies;
import com.example.movies.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private MoviesRepo moviesRepo;

    @Autowired
    private ActorsService actorsService;

    @Transactional
    @Override
    public Movies saveMovies(Movies newMovie){
        List<Actors> cast = newMovie.getActors();
        actorsService.saveAllActors(cast);
//        .save(newActor.getFavoriteMovie());
       return moviesRepo.save(newMovie);
    }

    @Override
    public boolean existsMoviesById(long id) {
        return moviesRepo.existsById(id);
    }

    @Override
    public List<Movies> saveAllMovies(List<Movies> moviesList) {
        return (List<Movies>) moviesRepo.saveAll(moviesList);
    }
}
