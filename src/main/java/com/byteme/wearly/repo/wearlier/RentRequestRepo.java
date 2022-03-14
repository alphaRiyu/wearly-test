package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.RentRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 11:39 AM
 */

@Repository
public interface RentRequestRepo extends JpaRepository<RentRequest, Long> {

    RentRequest findByRentId(Long clotheId);
    List<RentRequest> findAllByReceiverId(@Param("id") Long id, Sort sort);

}
