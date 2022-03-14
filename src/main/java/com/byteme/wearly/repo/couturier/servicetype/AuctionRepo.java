package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Auction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:05 PM
 */

@Repository
public interface AuctionRepo extends JpaRepository<Auction, Long> {

    List<Auction> findAllByCouturierId(@Param("id") Long id, Sort sort);

}
