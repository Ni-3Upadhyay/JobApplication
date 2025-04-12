package com.nitin.firstjobapp.reviews.reviewController;

import com.nitin.firstjobapp.company.companyentity.Company;
import com.nitin.firstjobapp.reviews.ReviewEntity.Review;
import com.nitin.firstjobapp.reviews.reviewService.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review/{id}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> addReview(@PathVariable Long id, @RequestBody Review review){

        if(reviewService.addReview(id, review)){
            return new ResponseEntity<>("Review created successfully", HttpStatus.OK);

        }
    return new ResponseEntity<>("not created", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/review/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id, @PathVariable Long reviewId){

        Review review = reviewService.getReviewById(id, reviewId);

        if(review == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PutMapping("/update/review/{reviewId}")
    public ResponseEntity<Review> updateReviewById(@PathVariable Long id, @PathVariable Long reviewId, @RequestBody Review review){

        Review updatedReview = reviewService.updateReviewById(id, reviewId, review);

        if(updatedReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable Long id, @PathVariable Long reviewId){

        Review deletedReview = reviewService.deleteReviewById(id, reviewId);

        if(deletedReview == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedReview,HttpStatus.OK);
    }




}
