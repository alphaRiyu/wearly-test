package com.byteme.wearly.service.couturier.category;

import com.byteme.wearly.model.couturier.category.Category;
import com.byteme.wearly.repo.couturier.category.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 11:32 PM
 */

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    // TODO: 2/15/2022 validate category to be added 
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    public Category getById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
    }

    public List<Category> getList() {
        return categoryRepo.findAll();
    }

    // TODO: 2/15/2022 check for error in validation
    public Category update(Long id, Category category) {
        Category currentCategory = categoryRepo
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Category not found"));
        if (category.getClothingFor() != null && category.getClothingFor().length() > 0) {
            currentCategory.setClothingFor(category.getClothingFor());
        }
        if (category.getType() != null && category.getType().length() > 0) {
            currentCategory.setType(category.getType());
        }
        return categoryRepo.save(category);
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
