package com.example.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date create_at;

    private Date updated_at;

    @Column(nullable = false)
    private String name;

    private Integer ranking;

    private int active;

    @OneToMany(mappedBy = "genres")
    @JsonIgnoreProperties({"genres", "actors"})
    private List<Movies> moviesList;

}
