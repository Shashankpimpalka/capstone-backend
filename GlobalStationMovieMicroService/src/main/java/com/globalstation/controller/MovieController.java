package com.globalstation.controller;

import com.globalstation.entity.MovieModel;
import com.globalstation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<List<MovieModel>> getAllMovie() {

        return ResponseEntity.ok( movieService.getAllMovie());
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable int id) {

        return ResponseEntity.ok( movieService.getMovieById(id));
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieModel> createMovie(@RequestBody MovieModel movieModel) {
        return new ResponseEntity<>(movieService.saveMovie(movieModel), HttpStatus.CREATED);
    }

    @PutMapping("/movie")
    public ResponseEntity<MovieModel> updateMovie(@RequestBody MovieModel movieModel) {
        return ResponseEntity.ok(movieService.updateMovie(movieModel));
    }

    @DeleteMapping(value = "/movie/{id}")
    public ResponseEntity<MovieModel> deleteMovie(@PathVariable int id) {

        return ResponseEntity.ok(movieService.deleteMovie(id));
    }

    @GetMapping(value = "/movie/byname/{movieTitle}")
    public ResponseEntity<List<MovieModel>> searchMovieByName(@PathVariable String movieTitle){
        return ResponseEntity.ok(movieService.getMovieByName(movieTitle));
    }

    


}
