package com.globalstation.controller;


import com.globalstation.entity.ReviewModel;
import com.globalstation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0")

@CrossOrigin("http://localhost:4200")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<List<ReviewModel>> getAllReview(){
        return ResponseEntity.ok( reviewService.getAllReview());
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewModel> getReviewById(@PathVariable int id){

        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewModel> saveReview(@RequestBody ReviewModel reviewModel){
        return new ResponseEntity<>(reviewService.saveReview(reviewModel), HttpStatus.CREATED);
    }

    @PutMapping("/review")
    public ResponseEntity<ReviewModel> updateReview(@RequestBody ReviewModel reviewModel){
        return ResponseEntity.ok(reviewService.updateReview(reviewModel));
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<ReviewModel> deleteReview(int id){
        return ResponseEntity.ok(reviewService.deleteReview(id));
    }

}
