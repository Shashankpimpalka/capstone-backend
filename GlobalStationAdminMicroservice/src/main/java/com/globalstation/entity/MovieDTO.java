package com.globalstation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {



    int movieId;


    String movieTitle;


    int movieCost;

    int movieYear;

//    @OneToMany(targetEntity = ReviewModel.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "review_id", referencedColumnName = "movie_id")
//    private List<ReviewModel> reviewModelList;

//    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Set<ActorModel> actors = new HashSet<>();

}
