package com.byteme.wearly.repo.couturier.category;

import com.byteme.wearly.model.couturier.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 11:31 PM
 */

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {
}
