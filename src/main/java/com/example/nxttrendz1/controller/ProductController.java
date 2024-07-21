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
import com.example.nxttrendz1.service.ProductJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




/**
 * ProductController
 */
@RestController
public class ProductController {

    @Autowired 
    private ProductJpaService productJpaService;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return productJpaService.getProducts();
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productJpaService.getProductById(id);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody  Product product) {
        return productJpaService.updateProduct(id, product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productJpaService.deleteProduct(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}