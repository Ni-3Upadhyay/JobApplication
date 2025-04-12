package com.nitin.firstjobapp.reviews.reviewService.impl;

import com.nitin.firstjobapp.company.companyentity.Company;
import com.nitin.firstjobapp.company.companyservice.service.CompanyService;
import com.nitin.firstjobapp.reviews.ReviewEntity.Review;
import com.nitin.firstjobapp.reviews.reviewRepository.ReviewRepository;
import com.nitin.firstjobapp.reviews.reviewService.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService){
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {

        return reviewRepository.findByCompanyId(companyId);
    }


    public boolean addReview(Long companyId, Review review){

        Company company = companyService.getCompanyById(companyId);

        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }

        return false;
    }

    public Review getReviewById(Long id, Long reviewId){

        List<Review> reviews = reviewRepository.findByCompanyId(id);

        return reviews.stream()
                .filter(review -> reviewId != null && reviewId.equals(review.getId()))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Review updateReviewById(Long id, Long reviewId, Review review) {

        Optional<Review> reviewToUpdate = reviewRepository.findByCompany_IdAndId(id, reviewId);

        if(reviewToUpdate.isPresent()){
            System.out.println(reviewToUpdate);
            Review updatedReview = reviewToUpdate.get();

            updatedReview.setRatings(review.getRatings());
            updatedReview.setDescription(review.getDescription());
            updatedReview.setTitle(review.getTitle());

            reviewRepository.save(updatedReview);
            return updatedReview;
        }
        return null;
    }

    @Override
    public Review deleteReviewById(Long id, Long reviewId) {

        Optional<Review> deleteReview = reviewRepository.findByCompany_IdAndId(id, reviewId);
        Review review = null;
        if(deleteReview.isPresent()){
            review = deleteReview.get();
            reviewRepository.deleteById(reviewId);
        }

        return review;
    }


}
