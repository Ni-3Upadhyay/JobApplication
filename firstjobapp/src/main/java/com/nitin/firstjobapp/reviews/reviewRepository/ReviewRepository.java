package com.nitin.firstjobapp.reviews.reviewRepository;

import com.nitin.firstjobapp.reviews.ReviewEntity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
