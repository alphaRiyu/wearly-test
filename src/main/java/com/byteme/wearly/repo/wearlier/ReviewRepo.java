package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.Review;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:59 PM
 */

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAllByClotheId(Long id, Sort sort);

}
