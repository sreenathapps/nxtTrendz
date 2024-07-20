/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.service.ReviewJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * ReviewController
 */
@RestController
public class ReviewController {
    @Autowired 
    private ReviewJpaService reviewJpaService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getReviews() {
        return reviewJpaService.getReviews();
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewJpaService.addReview(review);
    }

    @GetMapping("/products/reviews/{id}")
    public Review getReview(@PathVariable("id") int id) {
        return reviewJpaService.getReviewById(id);
    }
    @PutMapping("products/reviews/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        return reviewJpaService.updateReview(id, review);
    }
    @DeleteMapping("/products/reviews/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        reviewJpaService.deleteReview(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/reviews/{id}/product")
    public Product getReviewProduct(@PathVariable("id") int id) {
        return reviewJpaService.getReviewProduct(id);
    }
    
}