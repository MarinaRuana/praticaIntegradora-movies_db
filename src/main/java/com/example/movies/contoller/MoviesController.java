package com.example.movies.contoller;

import com.example.movies.models.Movies;
import com.example.movies.repository.MoviesRepo;
import com.example.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesRepo repo;

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Movies> saveNewMovie(@RequestBody Movies newMovie){
        return ResponseEntity.ok(moviesService.saveMovies(newMovie));
    }
}
