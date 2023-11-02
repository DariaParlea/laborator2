package org.example.repositories;

import org.example.model.Review;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {

    private List<Review> reviews = new ArrayList<>();

    public Review findById(int targetReviewId) {
        for (Review review : reviews) {
            if (review.getReview_id() == targetReviewId) {
                return review;
            }
        }
        return null;
    }

    public List<Review> findAll() {
        return reviews;
    }

    public void save(Review review) {
        reviews.add(review);
    }

    public void update(Review updatedReview) {
        for (Review review : reviews) {
            if (review.getReview_id() == updatedReview.getReview_id()) {
                review.setStars_number(updatedReview.getStars_number());
                review.setFeedback(updatedReview.getFeedback());
                review.setBook_id(updatedReview.getBook_id());
                review.setDate(updatedReview.getDate());
                break;
            }
        }
    }

    public void delete(int targetReviewId) {
        Review reviewToRemove = null;
        for (Review review : reviews) {
            if (review.getReview_id() == targetReviewId) {
                reviewToRemove = review;
                break;
            }
        }
        if (reviewToRemove != null) {
            reviews.remove(reviewToRemove);
        }
    }
}
