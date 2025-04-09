package com.nitin.firstjobapp.reviews.reviewController;

import com.nitin.firstjobapp.reviews.reviewService.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

}
