package com.example.movies.contoller;

import com.example.movies.models.Movies;
import com.example.movies.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesRepo repo;

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }
}
