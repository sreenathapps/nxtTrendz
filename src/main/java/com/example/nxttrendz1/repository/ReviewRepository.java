/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;

/**
 * ReviewRepository
 */
public interface ReviewRepository {

    ArrayList<Review> getReviews();
    Review getReviewById(int id);
    Review addReview(Review review);
    Review updateReview(int id, Review review);
    void deleteReview(int id);
    Product getReviewProduct(int reviewId);
}