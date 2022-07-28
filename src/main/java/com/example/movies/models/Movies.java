package com.example.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date create_at;

    private Date updated_at;

    @Column(nullable = false)
    private String title;

    private double rating;

    private Integer awards;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date release_date;

    private Integer length;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("moviesList")
    private Genres genres;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.REFRESH)
    @JsonIgnoreProperties({"favoriteMovie", "genres", "movies"})
    private List<Actors> actors;

}
