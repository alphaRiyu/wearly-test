package com.byteme.wearly.controller.couturier.category;

import com.byteme.wearly.model.couturier.category.SubCategory;
import com.byteme.wearly.service.couturier.category.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 12:15 AM
 */

@RestController
@RequestMapping("/subcategory")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) {
        return new ResponseEntity<>(subCategoryService.create(subCategory), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(subCategoryService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<SubCategory>> getAllSubCategory() {
        return new ResponseEntity<>(subCategoryService.getList(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable("id") Long id, @RequestBody SubCategory subCategory) {
        return new ResponseEntity<>(subCategoryService.update(id, subCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable("id") Long id) {
        subCategoryService.delete(id);
        return new ResponseEntity<>("Subcategory deleted.", HttpStatus.OK);
    }
}
