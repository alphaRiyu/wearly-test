package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.BidStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 9:40 AM
 */

@Repository
public interface BidStatusRepo extends JpaRepository<BidStatus, Long> {

    List<BidStatus> findAllByAuctionId(Long clothe_id, Sort sort);
    List<BidStatus> findAllByReceiverId(@Param("id") Long id, Sort sort);

}
