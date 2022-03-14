package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Sale;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 10:50 PM
 */

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {

    List<Sale> findAllByCouturierId(@Param("id") Long id, Sort sort);

}
