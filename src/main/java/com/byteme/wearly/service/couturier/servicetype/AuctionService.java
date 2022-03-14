package com.byteme.wearly.service.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Auction;
import com.byteme.wearly.repo.couturier.servicetype.AuctionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:05 PM
 */

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepo auctionRepo;

    public Auction create(Auction auction) {
        return auctionRepo.save(auction);
    }

    public Auction getById(Long id) {
        if (auctionRepo.findById(id).isPresent()) {
            return auctionRepo.findById(id).get();
        }
        throw new IllegalStateException("Id not found");
    }

    public List<Auction> getList() {
        return auctionRepo.findAll();
    }

    public List<Auction> getListByCouturierId(Long id) {
        return auctionRepo.findAllByCouturierId(id, Sort.by("createdAt"));
    }


}
