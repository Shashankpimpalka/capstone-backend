package com.globalstation.service;

import com.globalstation.entity.ReviewModel;
import com.globalstation.exception.ReviewNotFound;
import com.globalstation.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.SpinnerUI;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewModel> getAllReview(){
        return reviewRepository.findAll();
    }

    public ReviewModel getReviewById(int id){
        return reviewRepository.findById(id).orElseThrow(
                ()->new ReviewNotFound("Review not found for given id "+id));

    }

    public  ReviewModel saveReview(ReviewModel reviewModel){
        return reviewRepository.save(reviewModel);
    }

    public ReviewModel updateReview(ReviewModel reviewModel){
        ReviewModel reviewModel1 = reviewRepository.findById(reviewModel.getReviewId()).orElseThrow(
                ()->new ReviewNotFound("Review not found for given id "+reviewModel.getReviewId())
        );

        reviewModel1.setDate(reviewModel.getDate());
        reviewModel1.setDescr(reviewModel.getDescr());
        reviewModel1.setRating(reviewModel.getRating());
        reviewModel1.setMovieId(reviewModel.getMovieId());
        reviewModel1.setAdminId(reviewModel.getAdminId());

        return reviewRepository.save(reviewModel1);

    }


    public ReviewModel deleteReview(int id){
        ReviewModel reviewModel1 = reviewRepository.findById(id).orElseThrow(
                ()->new ReviewNotFound("Review not found for given id "+id)
        );

        reviewRepository.deleteById(reviewModel1.getReviewId());

        return reviewModel1;

    }


}
