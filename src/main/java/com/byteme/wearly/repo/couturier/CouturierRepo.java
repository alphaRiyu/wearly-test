package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.Couturier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 12:59 PM
 */

@Repository
public interface CouturierRepo extends JpaRepository<Couturier, Long> {

    @Modifying
    @Query(value = "INSERT INTO " +
            "couturier (user_id) " +
            "VALUES (:id)", nativeQuery = true)
    void addCouturierById(@Param("id") Long id);

}
