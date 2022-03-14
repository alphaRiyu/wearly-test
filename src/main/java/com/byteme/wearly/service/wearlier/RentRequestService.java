package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.RentRequest;
import com.byteme.wearly.repo.wearlier.RentRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 11:39 AM
 */

@Service
@RequiredArgsConstructor
public class RentRequestService {

    private final RentRequestRepo rentRequestRepo;

    // TODO: 2/25/2022 restrict if the selected dates are not available
    public RentRequest create(RentRequest rentRequest) {
        return rentRequestRepo.save(rentRequest);
    }

    public RentRequest getByClotheId(Long clotheId) {
        return rentRequestRepo.findByRentId(clotheId);
    }

    public List<RentRequest> getList(Long receiverId) {
        return rentRequestRepo.findAllByReceiverId(receiverId, Sort.by("createdAt"));
    }
}
