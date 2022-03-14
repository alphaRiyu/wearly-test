package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.ClotheImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 13, 2022 11:39 AM
 */

@Repository
public interface ClotheImageRepo extends JpaRepository<ClotheImage, Long> {

    @Modifying
    @Query(value = "INSERT INTO clothe_image (clothe_id, clothe_image) " +
            "VALUES (:id, :image)", nativeQuery = true)
    void addClotheImage(@Param("id") Long id, @Param("image") String image);
    List<ClotheImage> findAllByClotheId(Long id);
}
