package com.byteme.wearly.service.couturier.category;

import com.byteme.wearly.model.couturier.category.SubCategory;
import com.byteme.wearly.repo.couturier.category.SubCategoryRepo;
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
public class SubCategoryService {

    private final SubCategoryRepo subCategoryRepo;

    // TODO: 2/15/2022 validate entry 
    public SubCategory create(SubCategory subCategory) {
        return subCategoryRepo.save(subCategory);
    }

    public SubCategory getById(Long id) {
        return subCategoryRepo.findById(id).orElseThrow(() -> new IllegalStateException("Subcategory not found"));
    }

    public List<SubCategory> getList() {
        return subCategoryRepo.findAll();
    }

    // TODO: 2/15/2022 validate entry
    public SubCategory update(Long id, SubCategory subCategory) {
        SubCategory currentSubCategory = subCategoryRepo
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Sub category not found"));
        if (subCategory.getSubType() != null && subCategory.getSubType().length() > 0) {
            currentSubCategory.setSubType(subCategory.getSubType());
        }
        return subCategoryRepo.save(subCategory);
    }

    public void delete(Long id) {
        subCategoryRepo.deleteById(id);
    }
}
