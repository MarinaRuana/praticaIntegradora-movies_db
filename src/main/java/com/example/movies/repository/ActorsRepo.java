package com.example.movies.repository;

import com.example.movies.models.Actors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepo extends CrudRepository<Actors, Long> {
}
