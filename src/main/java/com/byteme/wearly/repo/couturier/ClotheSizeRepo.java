package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.ClotheSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 5:43 PM
 */

@Repository
public interface ClotheSizeRepo extends JpaRepository<ClotheSize, Long> {

    List<ClotheSize> findAllByClotheId(Long clotheId);

}
