package com.nitin.firstjobapp.reviews.reviewRepository;

import com.nitin.firstjobapp.reviews.ReviewEntity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);

    Optional<Review> findByCompany_IdAndId(Long companyId, Long id);
}
