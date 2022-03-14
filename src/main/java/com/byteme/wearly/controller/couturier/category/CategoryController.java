package com.byteme.wearly.controller.couturier.category;

import com.byteme.wearly.model.couturier.category.Category;
import com.byteme.wearly.service.couturier.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 12:01 AM
 */

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getList(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>("Category deleted.", HttpStatus.OK);
    }
}
