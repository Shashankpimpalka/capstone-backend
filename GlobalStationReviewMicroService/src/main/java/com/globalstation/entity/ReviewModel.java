package com.globalstation.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "date_posted")
    private Date date;

    @Column(name = "descr")
    private String descr;

    @Column(name = "rating")
    private int rating;

    @Column(name = "movie_id")
    private int movieId;

    private int adminId;


}
