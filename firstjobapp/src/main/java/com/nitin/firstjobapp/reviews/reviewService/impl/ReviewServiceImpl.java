package com.nitin.firstjobapp.reviews.reviewService.impl;

import com.nitin.firstjobapp.reviews.reviewRepository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl {

    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


}
