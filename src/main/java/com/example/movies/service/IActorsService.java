package com.example.movies.service;

import com.example.movies.models.Actors;

import java.util.List;

public interface IActorsService {

    Actors saveActors(Actors newAuthor);

     List<Actors> saveAllActors(List<Actors> actorsList);
}
