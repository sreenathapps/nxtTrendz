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
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ProductRepository;

import net.bytebuddy.asm.Advice.Return;

/**
 * ProductJpaService
 */
@Service
public class ProductJpaService implements ProductRepository{

    @Autowired
    private ProductJpaRepository productJpaRepository;

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
    public Product updateProduct(int id, Product product) {
        try {
            Product newProduct = productJpaRepository.findById(id).get();
            if (product.getPrice() != 0) {
                newProduct.setPrice(product.getPrice());
            }
            if (product.getProductName() != null) {
                newProduct.setProductName(product.getProductName());
            }
            return productJpaRepository.save(newProduct);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        productJpaRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    
}