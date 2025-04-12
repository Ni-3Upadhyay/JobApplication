package com.nitin.firstjobapp.reviews.reviewService.service;

import com.nitin.firstjobapp.reviews.ReviewEntity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long id, Long reviewId);

    Review updateReviewById(Long id, Long reviewId, Review review);

    Review deleteReviewById(Long id, Long reviewId);
}
