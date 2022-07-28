package com.example.movies.service;

import com.example.movies.models.Actors;
import com.example.movies.models.Movies;
import com.example.movies.repository.ActorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ActorsService implements IActorsService{

    @Autowired
    private ActorsRepo actorsRepo;

    @Autowired
    private MoviesService moviesService;

    @Transactional
    @Override
    public Actors save(Actors newActor) {
        List<Movies> movies = newActor.getMovies();
        moviesService.saveAll(movies);
        moviesService.save(newActor.getFavoriteMovie());
        return actorsRepo.save(newActor);
    }

}
