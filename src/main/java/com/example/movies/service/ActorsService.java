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


    @Override
    public Actors saveActors(Actors newActor) {
        return actorsRepo.save(newActor);
    }

    @Override
    public List<Actors> saveAllActors(List<Actors> actorsList) {
        return (List<Actors>) actorsRepo.saveAll(actorsList);
    }

}
