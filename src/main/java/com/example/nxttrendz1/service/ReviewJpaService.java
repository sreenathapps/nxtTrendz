/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;

/**
 * ReviewJpaService
 */
@Service
public class ReviewJpaService implements ReviewRepository {

    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> reviewList = reviewJpaRepository.findAll();
        return new ArrayList<>(reviewList);
    }

    @Override
    public Review getReviewById(int id) {
        try {
            Review review = reviewJpaRepository.findById(id).get();
            return review; 
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review addReview(Review review) {
        try {
            int productId = review.getProduct().getProductId();
            Product completeProduct = productJpaRepository.findById(productId).get();
            review.setProduct(completeProduct);
            return reviewJpaRepository.save(review);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updateReview(int id, Review review) {
        try {
            Review newReview = reviewJpaRepository.findById(id).get();
            if (review.getRating() != 0) {
                newReview.setRating(review.getRating());
            }
            if (review.getReviewContent() != null) {
                newReview.setReviewContent(review.getReviewContent());                
            }
            if (review.getProduct() != null) {
                newReview.setProduct(review.getProduct());
            }
            return reviewJpaRepository.save(newReview);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int id) {
        try {
            reviewJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getReviewProduct(int id) {
        try {
            Review review = reviewJpaRepository.findById(id).get();
            return review.getProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    
}