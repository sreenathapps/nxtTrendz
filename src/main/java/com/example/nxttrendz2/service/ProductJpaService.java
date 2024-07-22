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
package com.example.nxttrendz2.service;

import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.ProductJpaRepository;
import com.example.nxttrendz2.repository.ProductRepository;

/**
 * ProductJpaService
 */
@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productJpaRepository;
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> productList = productJpaRepository.findAll();
        return new ArrayList<>(productList);
    }

    @Override
    public Product getProductById(int id) {
        try {
            Product product = productJpaRepository.findById(id).get();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        try {
            product.setId(0);
            Category completeCategory = categoryJpaRepository.findById(product.getCategory().getId()).get();
            product.setCategory(completeCategory);
            productJpaRepository.save(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(int id, Product product) {
        try {
            Product newProduct = productJpaRepository.findById(id).get();
            if (product.getName() != null) {
                newProduct.setName(product.getName());
            }
            if (product.getDescription() != null) {
                newProduct.setDescription(product.getDescription());
            }
            if (product.getPrice() != 0) {
                newProduct.setPrice(product.getPrice());
            }
            if (product.getCategory() != null) {
                Category completeCategory = categoryJpaRepository.findById(product.getCategory().getId()).get();
                newProduct.setCategory(completeCategory);
            }
            productJpaRepository.save(newProduct);
            return newProduct;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category getProductCategory(int id) {
        try {
            Product product = productJpaRepository.findById(id).get();
            return product.getCategory();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}