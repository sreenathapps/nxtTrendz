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
package com.example.nxttrendz2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.service.ProductJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * ProductController
 */
@RestController
public class ProductController {
    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping("/categories/products")
    public ArrayList<Product> getProducts() {
        return productJpaService.getProducts();
    }

    @GetMapping("/categories/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productJpaService.getProductById(id);
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @PutMapping("/categories/products/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productJpaService.updateProduct(id, product);
    }

    @DeleteMapping("categories/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productJpaService.deleteProduct(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @GetMapping("products/{id}/category")
    public Category getProductCategory(@PathVariable("id") int id) {
        return productJpaService.getProductCategory(id);
    }

}