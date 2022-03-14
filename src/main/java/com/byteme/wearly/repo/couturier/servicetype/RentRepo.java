package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Rent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 3:25 PM
 */

@Repository
public interface RentRepo extends JpaRepository<Rent, Long> {

    List<Rent> findAllByCouturierId(@Param("id") Long id, Sort sort);

}
