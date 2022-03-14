package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.BidStatus;
import com.byteme.wearly.repo.wearlier.BidStatusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 9:45 AM
 */

@Service
@RequiredArgsConstructor
public class BidStatusService {

    private final BidStatusRepo bidStatusRepo;

    // TODO: 2/25/2022 restrict couturier to bid on their auctioned clothe
    public BidStatus create(BidStatus bidStatus) {
        return bidStatusRepo.save(bidStatus);
    }

    public List<BidStatus> getListByAuctionId(Long auctionId) {
        return bidStatusRepo.findAllByAuctionId(auctionId, Sort.by("bidAmount").descending());
    }

    public List<BidStatus> getList(Long id) {
        return bidStatusRepo.findAllByReceiverId(id, Sort.by("createdAt").descending());
    }
}
