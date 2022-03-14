package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Customize;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:37 PM
 */

@Repository
public interface CustomizeRepo extends JpaRepository<Customize, Long> {

    List<Customize> findAllByCouturierId(@Param("id") Long id, Sort sort);

}
