package com.byteme.wearly.repo.couturier.category;

import com.byteme.wearly.model.couturier.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 11:30 PM
 */

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
