package com.example.movies.repository;

import com.example.movies.models.Movies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepo extends CrudRepository<Movies, Long> {
}
