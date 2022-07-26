package com.example.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String create_at;

    private String updated_at;

    private String first_name;

    private String last_name;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnoreProperties({"actors", "genres"})
    private Movies favoriteMovie;

    @ManyToMany
    @JoinTable(name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    @JsonIgnoreProperties({"genres", "actors"})
    private List<Movies> movies;

}
