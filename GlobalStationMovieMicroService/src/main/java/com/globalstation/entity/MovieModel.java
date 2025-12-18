package com.globalstation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    int movieId;

    @Column(name = "movie_title")
    String movieTitle;

    @Column(name = "movie_cost")
    int movieCost;

    @Column(name = "movie_year")
    int movieYear;

//    @OneToMany(targetEntity = ReviewModel.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "review_id", referencedColumnName = "movie_id")
//    private List<ReviewModel> reviewModelList;

//    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Set<ActorModel> actors = new HashSet<>();

}
