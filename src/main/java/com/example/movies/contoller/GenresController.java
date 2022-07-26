package com.example.movies.contoller;

import com.example.movies.models.Genres;
import com.example.movies.repository.GenresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresRepo repo;

    @GetMapping("/{id}")
    public ResponseEntity<Genres> getGenreById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }
}
