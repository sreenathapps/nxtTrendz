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

/**
 * ProductRepository
 */
public interface ProductRepository {

    ArrayList<Product> getProducts();
    Product getProductById(int id);
    Product updateProduct(int id, Product product);
    Product addProduct(Product product);
    void deleteProduct(int id);
     
}