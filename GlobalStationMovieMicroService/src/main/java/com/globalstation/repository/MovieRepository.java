package com.globalstation.repository;

import com.globalstation.entity.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieModel, Integer> {

    List<MovieModel> findMovieModelByMovieTitleContaining(String name);
}
