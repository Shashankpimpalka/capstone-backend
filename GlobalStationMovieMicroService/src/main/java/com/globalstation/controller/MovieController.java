package com.globalstation.controller;

import com.globalstation.entity.MovieModel;
import com.globalstation.service.MovieService;
import com.globalstation.service.OllamaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v0")
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;


    @Autowired
    private OllamaService ollamaService;


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


    @GetMapping(value = "/ask", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String,Object>> ask(@RequestParam String prompt) {
        log.info("Received prompt: {}", prompt);
        return ollamaService.askQuestion("qwen2.5-coder:7b", prompt);
    }

    


}
