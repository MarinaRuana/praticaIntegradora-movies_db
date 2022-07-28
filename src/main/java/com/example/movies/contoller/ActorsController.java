package com.example.movies.contoller;

import com.example.movies.models.Actors;
import com.example.movies.repository.ActorsRepo;
import com.example.movies.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private ActorsRepo repo;

    @Autowired
    private ActorsService service;

    @GetMapping("/{id}")
    public ResponseEntity<Actors> getActorById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Actors> saveNewActor(@RequestBody Actors newActor){
        return ResponseEntity.ok(service.save(newActor));
    }
}
