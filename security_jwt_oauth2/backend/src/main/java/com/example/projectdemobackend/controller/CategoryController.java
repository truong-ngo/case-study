package com.example.projectdemobackend.controller;

import com.example.projectdemobackend.model.Category;
import com.example.projectdemobackend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findOne(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category Category) {
        return new ResponseEntity<>(categoryService.save(Category), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category Category) {
        return new ResponseEntity<>(categoryService.save(Category), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
