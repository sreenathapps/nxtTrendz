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
import com.example.nxttrendz2.service.CategoryJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * CategoryController
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryJpaService categoryJpaService;

    @GetMapping("/categories")
    public ArrayList<Category> getCategories() {
        return categoryJpaService.getCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable("id") int id) {
        return categoryJpaService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryJpaService.addCategory(category);
    }

    @PutMapping("categories/{id}")
    public Category updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        return categoryJpaService.updateCategory(id, category);
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryJpaService.deleteCategory(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
