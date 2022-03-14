package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 13, 2022 12:09 PM
 */

@Repository
public interface ClotheRepo extends JpaRepository<Clothe, Long> {
}
