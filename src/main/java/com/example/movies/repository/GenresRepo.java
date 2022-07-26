package com.example.movies.repository;

import com.example.movies.models.Genres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepo extends CrudRepository<Genres, Long> {
}
