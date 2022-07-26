package com.example.movies.contoller;

import com.example.movies.models.Actors;
import com.example.movies.repository.ActorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private ActorsRepo repo;

    @GetMapping("/{id}")
    public ResponseEntity<Actors> getActorById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }
}
