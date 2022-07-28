package com.example.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.spi.CascadingActions;

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

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnoreProperties({"actors", "genres"})
    private Movies favoriteMovie;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    @JsonIgnoreProperties({"genres", "actors"})
    private List<Movies> movies;

}
