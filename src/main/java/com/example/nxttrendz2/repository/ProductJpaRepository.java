/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.nxttrendz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nxttrendz2.model.Product;

/**
 * ProductJpaRepository
 */
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {}