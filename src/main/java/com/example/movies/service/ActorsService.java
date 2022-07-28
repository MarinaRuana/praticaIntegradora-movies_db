package com.example.movies.service;

import com.example.movies.models.Actors;
import com.example.movies.models.Movies;
import com.example.movies.repository.ActorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService{

    @Autowired
    private ActorsRepo actorsRepo;

    @Autowired
    private MoviesService moviesService;

    @Transactional
    @Override
    public Actors save(Actors newActor) {
//        List<Actors> actorsList = new ArrayList<>();
        List<Movies> movies = newActor.getMovies();
        List<Movies> copy = new ArrayList<>(movies);
      copy.forEach(movies1 -> {
//            if(movies1.getActors().contains(newActor)){
//                moviesService.save(movies1);
//            } else {
                List<Actors> actorsList = movies1.getActors();
                actorsList.add(newActor);
                movies1.setActors(actorsList);
//            }
        });
        newActor.setMovies(copy);
        moviesService.saveAll(copy);
        moviesService.save(newActor.getFavoriteMovie());
//        moviesService.saveAll(newActor.getMovies());
        return actorsRepo.save(newActor);
    }

}
